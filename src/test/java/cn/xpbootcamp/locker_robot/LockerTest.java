package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerTest {

    @Test
    public void should_store_bag_when_locker_has_available_space(){
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        assertNotNull(locker.store(bag));
    }

    @Test
    public void should_store_bag_when_locker_has_available_spece_and_return_receipt(){
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Receipt receipt = locker.store(bag);

        assertNotNull(receipt);
    }

    @Test
    public void should_store_two_bags_when_locker_has_available_spece_and_return_receipt(){
        Locker locker = new Locker(2);
        Bag bag_one = new Bag();
        Bag bag_two = new Bag();

        Receipt receipt_one = locker.store(bag_one);
        Receipt receipt_two = locker.store(bag_two);
        assertNotNull(receipt_one);
        assertNotNull(receipt_two);
    }

    @Test
    public void should_not_store_bag_when_locker_is_full(){
        Locker locker = new Locker(1);
        Bag bag_one = new Bag();
        Bag bag_two = new Bag();

        Receipt receipt_one = locker.store(bag_one);
        assertNotNull(receipt_one);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            locker.store(bag_two);
        });
        String expectedMessage = "Locker is full";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
