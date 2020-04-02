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
            return lockers[index].storeBag(bag);
        }
        return null;
    }

    public boolean lockerIsFull(Locker locker) {
        return locker.getAvailable_space() == 0;
    }
}