package cn.xpbootcamp.locker_robot;

public class SuperLockerRobot {

    private Locker[] lockers;

    public SuperLockerRobot(int[] lockerSizeArray) {
        lockers = new Locker[lockerSizeArray.length];
        for(int index = 0; index < lockerSizeArray.length; index++){
            lockers[index] = new Locker(lockerSizeArray[index]);
        }
    }

    public Receipt storeBag(Bag bag) {
        return lockers[0].storeBag(bag);
    }
}
