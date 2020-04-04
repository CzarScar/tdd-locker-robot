package cn.xpbootcamp.locker_robot;

public class Locker {
    private Bag[] bags;
    private Receipt[] receipts;
    private int availableSpace;

    public Locker(int capacity) {
        this.bags = new Bag[capacity];
        this.receipts = new Receipt[capacity];
        this.availableSpace = capacity;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    public Receipt storeBag(Bag bag) {
        if (0 == availableSpace) {
            throw new RuntimeException("Locker is full");
        }
        int availablePosition = 0;
        for (int index = 0; index < receipts.length; index++) {
            if (null == receipts[index]) {
                availablePosition = index;
                break;
            }
        }
        Receipt receipt = new Receipt(availablePosition);
        receipts[availablePosition] = receipt;
        bags[availablePosition] = bag;
        this.availableSpace -= 1;
        return receipt;
    }

    public Bag getBag(Receipt receipt) {
        Bag bag = bags[receipt.getStoredPosition()];
        if (receipts[receipt.getStoredPosition()] != receipt) {
            throw new RuntimeException("Invalid receipt");
        }
        bags[receipt.getStoredPosition()] = null;
        receipts[receipt.getStoredPosition()] = null;
        this.availableSpace += 1;
        return bag;
    }
}
