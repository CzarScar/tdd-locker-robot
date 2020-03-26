package cn.xpbootcamp.locker_robot;

public class Locker {
    private Bag[] bagArray;
    private int available_space;

    public Locker(int capacity) {
        this.bagArray = new Bag[capacity];
        this.available_space = capacity;
    }

    public Receipt store(Bag bag) {
        if(0 == available_space){
            throw new RuntimeException("Locker is full");
        }
        bagArray[0] = bag;
        this.available_space -= 1;
        return new Receipt();
    }
}
