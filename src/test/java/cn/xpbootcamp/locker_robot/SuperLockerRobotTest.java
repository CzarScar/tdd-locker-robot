package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperLockerRobotTest {

    @Test
    public void should_get_a_receipt_when_store_a_bag_given_super_locker_robot_with_lockers(){
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(new int[]{1, 2, 3});
        Bag bag = new Bag();

        Receipt receipt = superLockerRobot.storeBag(bag);

        assertNotNull(receipt);
    }

    @Test
    public void should_store_bag_in_first_locker_when_store_a_bag_given_super_locker_robot_with_same_vacancy_lockers(){
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(new int[]{1, 2, 3});
        Bag bag = new Bag();

        superLockerRobot.storeBag(bag);

        assertEquals(0,superLockerRobot.getLockers()[0].getAvailableSpace());
        assertEquals(2,superLockerRobot.getLockers()[1].getAvailableSpace());
        assertEquals(3,superLockerRobot.getLockers()[2].getAvailableSpace());
    }

    @Test
    public void should_store_bag_in_high_vacancy_rate_locker_when_store_a_bag_given_super_locker_robot_with_different_vacancy_rate_lockers(){
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(new int[]{2,3});
        Bag bagOne = new Bag();
        Bag bagTwo = new Bag();
        superLockerRobot.storeBag(bagOne);

        superLockerRobot.storeBag(bagTwo);

        assertEquals(1,superLockerRobot.getLockers()[0].getAvailableSpace());
        assertEquals(2,superLockerRobot.getLockers()[1].getAvailableSpace());
    }
}
