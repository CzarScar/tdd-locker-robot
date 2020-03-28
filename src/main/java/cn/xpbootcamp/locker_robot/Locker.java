package cn.xpbootcamp.locker_robot;

public class Locker {
    private Bag[] bags;
    private Receipt[] receipts;
    private int available_space;

    public Locker(int capacity) {
        this.bags = new Bag[capacity];
        this.receipts = new Receipt[capacity];
        this.available_space = capacity;
    }

    public Receipt storeBag(Bag bag) {
        if (0 == available_space) {
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
        this.available_space -= 1;
        return receipt;
    }

    public Bag getBag(Receipt receipt) {
        Bag bag = bags[receipt.getStore_position()];
        if (receipts[receipt.getStore_position()] != receipt) {
            throw new RuntimeException("Invalid receipt");
        }
        bags[receipt.getStore_position()] = null;
        receipts[receipt.getStore_position()] = null;
        this.available_space += 1;
        return bag;
    }
}
