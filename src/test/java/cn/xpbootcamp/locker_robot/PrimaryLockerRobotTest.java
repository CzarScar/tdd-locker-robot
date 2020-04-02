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

        Bag bagTwo = new Bag();
        primaryLockerRobot.storeBag(bagTwo);
        assertTrue(primaryLockerRobot.lockerIsFull(primaryLockerRobot.getLockers()[0]));
        assertTrue(primaryLockerRobot.lockerIsFull(primaryLockerRobot.getLockers()[1]));
    }

    @Test
    public void should_not_store_bag_when_has_a_bag_given_robots_lockers_are_all_full(){
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(2,1);
        Bag bagOne = new Bag();
        primaryLockerRobot.storeBag(bagOne);
        Bag bagTwo = new Bag();
        primaryLockerRobot.storeBag(bagTwo);

        Bag bag = new Bag();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            primaryLockerRobot.storeBag(bag);
        });
        String expectedMessage = "Lockers are all full";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void should_get_bag_when_use_the_receipt_given_store_a_bag_and_got_a_receipt(){
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(1,1);
        Bag bag = new Bag();

        Receipt receipt = primaryLockerRobot.storeBag(bag);

        assertSame(bag, primaryLockerRobot.getBag(receipt));
    }

    @Test
    public void should_not_get_bag_when_use_invalid_receipt_without_locker_info_given_store_a_bag(){
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(1,1);
        Bag bag = new Bag();
        Receipt validReceipt = primaryLockerRobot.storeBag(bag);

        Receipt invalidReceipt = new Receipt(0);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            primaryLockerRobot.getBag(invalidReceipt);
        });
        String expectedMessage = "Invalid receipt";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

        assertSame(bag, primaryLockerRobot.getBag(validReceipt));
    }

    @Test
    public void should_not_get_bag_when_use_invalid_receipt_with_locker_info_given_store_a_bag(){
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(1,1);
        Bag bag = new Bag();
        Receipt validReceipt = primaryLockerRobot.storeBag(bag);

        Receipt invalidReceipt = new Receipt(0);
        invalidReceipt.setStore_locker(0);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            primaryLockerRobot.getBag(invalidReceipt);
        });
        String expectedMessage = "Invalid receipt";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

        assertSame(bag, primaryLockerRobot.getBag(validReceipt));
    }
}
