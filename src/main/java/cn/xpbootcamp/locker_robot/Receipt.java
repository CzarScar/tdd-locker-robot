package cn.xpbootcamp.locker_robot;

public class Receipt {
    private int store_position;
    private int store_locker;

    public Receipt(int store_position) {
        this.store_position = store_position;
    }

    public int getStore_position() {
        return store_position;
    }

    public int getStore_locker() {
        return store_locker;
    }

    public void setStore_locker(int store_locker) {
        this.store_locker = store_locker;
    }
}
