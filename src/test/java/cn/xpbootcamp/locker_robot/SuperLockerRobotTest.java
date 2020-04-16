package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void should_not_store_bag_when_store_a_bag_given_super_locker_robot_with_all_lokers_are_full(){
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(new int[]{1,1});
        Bag bagOne = new Bag();
        Bag bagTwo = new Bag();
        Bag bagThree = new Bag();
        superLockerRobot.storeBag(bagOne);
        superLockerRobot.storeBag(bagTwo);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            superLockerRobot.storeBag(bagThree);
        });
        String expectedMessage = "Lockers are all full";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void should_get_bag_when_using_valid_receipt_given_store_bag_in_super_locker_robot() {
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(new int[]{1, 1});
        Bag bag = new Bag();

        Receipt validReceipt = superLockerRobot.storeBag(bag);

        assertSame(bag, superLockerRobot.getBag(validReceipt));
    }

    @Test
    public void should_not_get_bag_when_using_receipt_without_locker_info_given_store_bag_in_super_locker_robot(){
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(new int[]{1, 1});
        Bag bag = new Bag();

        Receipt validReceipt = superLockerRobot.storeBag(bag);

        Receipt invalidReceipt = new Receipt(0);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            superLockerRobot.getBag(invalidReceipt);
        });
        String expectedMessage = "Invalid receipt";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);

        assertSame(bag, superLockerRobot.getBag(validReceipt));
    }

    @Test
    public void should_not_get_bag_when_using_receipt_with_locker_info_given_store_bag_in_super_locker_robot(){
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(new int[]{1, 1});
        Bag bag = new Bag();

        Receipt validReceipt = superLockerRobot.storeBag(bag);

        Receipt invalidReceipt = new Receipt(2);
        invalidReceipt.setLockerInfo(3);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            superLockerRobot.getBag(invalidReceipt);
        });
        String expectedMessage = "Invalid receipt";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);

        assertSame(bag, superLockerRobot.getBag(validReceipt));
    }

    @Test
    public void should_not_get_bag_when_using_reused_receipt_given_store_bag_in_super_locker_robot(){
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(new int[]{1, 1});
        Bag bag = new Bag();

        Receipt validReceipt = superLockerRobot.storeBag(bag);
        assertSame(bag, superLockerRobot.getBag(validReceipt));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            superLockerRobot.getBag(validReceipt);
        });
        String expectedMessage = "Invalid receipt";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

}
