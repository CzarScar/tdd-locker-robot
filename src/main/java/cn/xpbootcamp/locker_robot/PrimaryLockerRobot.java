package cn.xpbootcamp.locker_robot;

public class PrimaryLockerRobot {

    private Locker[] lockers;

    public PrimaryLockerRobot(int lockerNum, int eachLockerCapacity) {
        this.lockers = new Locker[lockerNum];
        for(int index = 0; index < lockerNum; index++){
            lockers[index] = new Locker(eachLockerCapacity);
        }
    }

    public Locker[] getLockers() {
        return lockers;
    }

    public Receipt storeBag(Bag bag) {
        for(int index = 0; index < lockers.length; index++){
            if(lockerIsFull(lockers[index])){
                continue;
            }
            Receipt receipt =  lockers[index].storeBag(bag);
            receipt.setStore_locker(index);
            return receipt;
        }
        throw new RuntimeException("Lockers are all full");
    }

    public boolean lockerIsFull(Locker locker) {
        return locker.getAvailable_space() == 0;
    }

    public Bag getBag(Receipt receipt) {
        return lockers[receipt.getStore_locker()].getBag(receipt);
    }
}
