package cn.xpbootcamp.locker_robot;

public class SmartLockerRobot {
    private Locker[] lockers;
    public SmartLockerRobot(int lockerNum, int eachLockerCapacity) {
        lockers = new Locker[lockerNum];
        for(int index = 0; index < lockerNum; index++){
            lockers[index] = new Locker(eachLockerCapacity);
        }
    }

    public Locker[] getLockers() {
        return lockers;
    }

    public Receipt storeBag(Bag bag) {
        int maxAvailableSpace = 0;
        int storedLocker = 0;
        for(int index = 0; index < this.lockers.length; index++){
            int lockerAvailableSpace = this.lockers[index].getAvailableSpace();
            if (lockerAvailableSpace > maxAvailableSpace){
                maxAvailableSpace = lockerAvailableSpace;
                storedLocker = index;
            }
        }
        if(0 == maxAvailableSpace){
            throw new RuntimeException("Lockers are all full");
        }

        Receipt receipt = this.lockers[storedLocker].storeBag(bag);
        receipt.setStoredLocker(storedLocker);
        return receipt;
    }

    public Bag getBag(Receipt receipt) {
        return this.lockers[receipt.getStoredLocker()].getBag(receipt);
    }
}
