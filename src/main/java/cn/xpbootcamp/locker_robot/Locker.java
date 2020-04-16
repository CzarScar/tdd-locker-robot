package cn.xpbootcamp.locker_robot;

public class Locker {
    private Bag[] bags;
    private Receipt[] receipts;
    private int availableSpace;
    private double vacancyRate;

    public Locker(int capacity) {
        this.bags = new Bag[capacity];
        this.receipts = new Receipt[capacity];
        this.availableSpace = capacity;
    }

    public Receipt storeBag(Bag bag) {
        if (0 == availableSpace) {
            throw new RuntimeException("Locker is full");
        }
        int available_position = 0;
        for (int index = 0; index < receipts.length; index++) {
            if (null == receipts[index]) {
                available_position = index;
                break;
            }
        }
        Receipt receipt = new Receipt(available_position);
        receipts[available_position] = receipt;
        bags[available_position] = bag;
        this.availableSpace -= 1;
        return receipt;
    }

    public Bag getBag(Receipt receipt) {
        Bag bag = bags[receipt.getStore_position()];
        if (receipts[receipt.getStore_position()] != receipt) {
            throw new RuntimeException("Invalid receipt");
        }
        bags[receipt.getStore_position()] = null;
        receipts[receipt.getStore_position()] = null;
        this.availableSpace += 1;
        return bag;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    public double getVacancyRate() {
        return (double)this.availableSpace/(this.availableSpace+this.receipts.length);
    }
}
