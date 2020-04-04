package cn.xpbootcamp.locker_robot;

public class Receipt {
    private int storedPosition;
    private int storedLocker;

    public Receipt(int storedPosition) {
        this.storedPosition = storedPosition;
    }

    public int getStoredPosition() {
        return storedPosition;
    }

    public int getStoredLocker() {
        return storedLocker;
    }

    public void setStoredLocker(int storedLocker) {
        this.storedLocker = storedLocker;
    }
}
