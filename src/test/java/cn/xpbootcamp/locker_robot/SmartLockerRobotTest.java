package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartLockerRobotTest {

    @Test
    public void should_get_receipt_when_store_a_bag_given_locker_under_smart_locker_robot_has_available_space(){
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(1,1);
        Bag bag = new Bag();
        Receipt receipt = smartLockerRobot.storeBag(bag);
        assertNotNull(receipt);
    }

    @Test
    public void should_store_bag_in_first_locker_when_store_a_bag_given_all_lockers_have_same_available_space_under_smart_locker_robot(){
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(2,2);
        Bag bag = new Bag();
        smartLockerRobot.storeBag(bag);

        assertEquals(1, smartLockerRobot.getLockers()[0].getAvailableSpace());
        assertEquals(2, smartLockerRobot.getLockers()[1].getAvailableSpace());
    }

    @Test
    public void should_store_bag_in_more_available_space_locker_when_store_a_bag_given_lockers_under_smart_locker_robot(){
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(2,2);
        Bag bagOne = new Bag();
        Bag bagTwo = new Bag();
        Receipt receiptOne = smartLockerRobot.storeBag(bagOne);
        assertEquals(1,smartLockerRobot.getLockers()[0].getAvailableSpace());
        assertEquals(2,smartLockerRobot.getLockers()[1].getAvailableSpace());
        Receipt receiptTwo = smartLockerRobot.storeBag(bagTwo);
        assertEquals(1,smartLockerRobot.getLockers()[0].getAvailableSpace());
        assertEquals(1,smartLockerRobot.getLockers()[1].getAvailableSpace());
    }

    @Test
    public void should_not_store_bag_when_store_a_bag_given_all_lockers_are_full_under_smart_locker_robot(){
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(2,1);
        Bag bag = new Bag();
        Bag bagOne = new Bag();
        Bag bagTwo = new Bag();
        smartLockerRobot.storeBag(bagOne);
        smartLockerRobot.storeBag(bagTwo);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            smartLockerRobot.storeBag(bag);
        });
        String expectedMessage = "Lockers are all full";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void should_get_bag_when_use_valid_receipt_given_store_a_bag_and_return_receipt(){
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(2,2);
        Bag bag = new Bag();
        Receipt receipt = smartLockerRobot.storeBag(bag);

        assertSame(bag, smartLockerRobot.getBag(receipt));
    }

    @Test
    public void should_not_get_bag_when_use_invalid_receipt_with_locker_info_given_store_bag_and_get_receipt(){
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(2,2);
        Bag bag = new Bag();
        Receipt validReceipt = smartLockerRobot.storeBag(bag);

        Receipt invalidReceiptWithLockerInfo = new Receipt(0);
        invalidReceiptWithLockerInfo.setStoredLocker(0);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            smartLockerRobot.getBag(invalidReceiptWithLockerInfo);
        });
        String expectedMessage = "Invalid receipt";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

        assertSame(bag, smartLockerRobot.getBag(validReceipt));
    }

    @Test
    public void should_not_get_bag_when_use_invalid_receipt_without_locker_info_given_store_bag_and_get_receipt(){
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(2,2);
        Bag bag = new Bag();
        Receipt validReceipt = smartLockerRobot.storeBag(bag);

        Receipt invalidReceiptWithLockerInfo = new Receipt(0);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            smartLockerRobot.getBag(invalidReceiptWithLockerInfo);
        });
        String expectedMessage = "Invalid receipt";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

        assertSame(bag, smartLockerRobot.getBag(validReceipt));
    }
}