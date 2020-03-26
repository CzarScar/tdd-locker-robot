package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerTest {

    @Test
    public void should_store_bag_when_locker_has_available_space(){
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        assertNotNull(locker.storeBag(bag));
    }

    @Test
    public void should_store_bag_when_locker_has_available_spece_and_return_receipt(){
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Receipt receipt = locker.storeBag(bag);

        assertNotNull(receipt);
    }

    @Test
    public void should_store_two_bags_when_locker_has_available_spece_and_return_receipt(){
        Locker locker = new Locker(2);
        Bag bag_one = new Bag();
        Bag bag_two = new Bag();

        Receipt receipt_one = locker.storeBag(bag_one);
        Receipt receipt_two = locker.storeBag(bag_two);
        assertNotNull(receipt_one);
        assertNotNull(receipt_two);
    }

    @Test
    public void should_not_store_bag_when_locker_is_full(){
        Locker locker = new Locker(1);
        Bag bag_one = new Bag();
        Bag bag_two = new Bag();

        Receipt receipt_one = locker.storeBag(bag_one);
        assertNotNull(receipt_one);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            locker.storeBag(bag_two);
        });
        String expectedMessage = "Locker is full";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void should_get_bag_when_receipt_is_valid(){
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Receipt receipt = locker.storeBag(bag);

        assertNotNull(locker.getBag(receipt));
    }

    @Test
    public void should_get_correct_bag_when_receipt_is_valid(){
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Receipt receipt = locker.storeBag(bag);

        Bag newBag = locker.getBag(receipt);

        assertEquals(bag, newBag);
    }

    @Test
    public void should_get_correct_bags_when_receipts_is_valid(){
        Locker locker = new Locker(2);
        Bag bag_one = new Bag();
        Bag bag_two = new Bag();

        Receipt receipt_one = locker.storeBag(bag_one);
        Receipt receipt_two = locker.storeBag(bag_two);

        Bag newBag_one = locker.getBag(receipt_one);
        Bag newBag_two = locker.getBag(receipt_two);

        assertEquals(bag_one, newBag_one);
        assertEquals(bag_two, newBag_two);
    }

}
