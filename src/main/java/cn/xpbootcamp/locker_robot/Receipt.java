package cn.xpbootcamp.locker_robot;

public class Receipt {
    private int store_position;
    private int lockerInfo;

    public Receipt(int store_position) {
        this.store_position = store_position;
    }

    public int getStore_position() {
        return store_position;
    }

    public int getLockerInfo() {
        return lockerInfo;
    }

    public void setLockerInfo(int lockerInfo) {
        this.lockerInfo = lockerInfo;
    }
}
