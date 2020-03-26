package cn.xpbootcamp.locker_robot;

public class Locker {
    private Bag[] bagArray;

    public Locker(int capacity) {
        this.bagArray = new Bag[capacity];
    }

    public Receipt store(Bag bag) {
        bagArray[0] = bag;
        return new Receipt();
    }
}
