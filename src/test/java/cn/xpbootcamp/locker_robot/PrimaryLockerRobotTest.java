package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimaryLockerRobotTest {

    @Test
    public void should_store_bag_when_has_a_bag_given_locker_under_robot_has_available_space(){
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(1,1);
        Bag bag = new Bag();

        assertNotNull(primaryLockerRobot.storeBag(bag));
    }

    @Test
    public void should_store_bag_in_first_available_locker_when_has_a_bag_given_two_lockers_under_robot_has_available_space(){
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(2,1);
        Bag bag = new Bag();
        primaryLockerRobot.storeBag(bag);

        assertTrue(primaryLockerRobot.lockerIsFull(primaryLockerRobot.getLockers()[0]));
        assertFalse(primaryLockerRobot.lockerIsFull(primaryLockerRobot.getLockers()[1]));
    }
}
