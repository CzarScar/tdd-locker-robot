package cn.xpbootcamp.locker_robot;

public class SmartLockerRobot {
    private Locker[] lockers;
    public SmartLockerRobot(int lockerNum, int eachLockerCapacity) {
        lockers = new Locker[lockerNum];
        for(int index = 0; index < lockerNum; index++){
            lockers[index] = new Locker(eachLockerCapacity);
        }
    }

    public Receipt storeBag(Bag bag) {
        return this.lockers[0].storeBag(bag);
    }
}
