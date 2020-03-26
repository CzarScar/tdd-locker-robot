package cn.xpbootcamp.locker_robot;

public class Locker {
    private Bag[] bagArray;
    private int available_space;

    public Locker(int capacity) {
        this.bagArray = new Bag[capacity];
        this.available_space = capacity;
    }

    public Receipt storeBag(Bag bag) {
        if(0 == available_space){
            throw new RuntimeException("Locker is full");
        }
        int available_position = 0;
        for(int index = 0; index < bagArray.length; index++){
            if(null == bagArray[index]){
                available_position = index;
                break;
            }
        }
        bagArray[available_position] = bag;
        this.available_space -= 1;
        return new Receipt(available_position);
    }

    public Bag getBag(Receipt receipt) {
        Bag bag = bagArray[receipt.getStore_position()];
        bagArray[receipt.getStore_position()] = null;
        this.available_space += 1;
        return bag;
    }
}
