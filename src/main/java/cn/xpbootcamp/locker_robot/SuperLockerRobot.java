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
        double vacancyRate = 0.0;
        int higherVacancyRateLockerIndex = 0;
        for(int index = 0; index < this.lockers.length; index++){
            double currentLockerVacancyRate = lockers[index].getVacancyRate();
            if(currentLockerVacancyRate > vacancyRate){
                vacancyRate = currentLockerVacancyRate;
                higherVacancyRateLockerIndex = index;
            }
        }
        return lockers[higherVacancyRateLockerIndex].storeBag(bag);
    }

    public Locker[] getLockers() {
        return lockers;
    }
}
