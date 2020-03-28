package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerTest {

    @Test
    public void should_store_bag_successfully_when_store_a_bag_given_locker_has_available_space() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        assertNotNull(locker.storeBag(bag));
    }

    @Test
    public void should_get_receipt_when_store_a_bag_given_locker_has_available_spece() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Receipt receipt = locker.storeBag(bag);

        assertNotNull(receipt);
    }

    @Test
    public void should_store_two_bags_when_store_two_bags_given_locker_has_available_spece() {
        Locker locker = new Locker(2);
        Bag bagOne = new Bag();
        Bag bagTwo = new Bag();

        Receipt receiptOne = locker.storeBag(bagOne);
        Receipt receiptTwo = locker.storeBag(bagTwo);
        assertNotNull(receiptOne);
        assertNotNull(receiptTwo);
    }

    @Test
    public void should_not_store_bag_when_store_a_bag_given_locker_is_full() {
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
    public void should_get_bag_when_get_a_bag_given_receipt_is_valid() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Receipt receipt = locker.storeBag(bag);

        assertNotNull(locker.getBag(receipt));
    }

    @Test
    public void should_get_correct_bag_when_get_a_bag_given_receipt_is_valid() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Receipt receipt = locker.storeBag(bag);

        Bag newBag = locker.getBag(receipt);

        assertSame(bag, newBag);
    }

    @Test
    public void should_get_correct_bags_when_get_two_bags_given_receipts_is_valid() {
        Locker locker = new Locker(2);
        Bag bagOne = new Bag();
        Bag bagTwo = new Bag();

        Receipt receiptOne = locker.storeBag(bagOne);
        Receipt receiptTwo = locker.storeBag(bagTwo);

        Bag newBagOne = locker.getBag(receiptOne);
        Bag newBagTwo = locker.getBag(receiptTwo);

        assertSame(bagOne, newBagOne);
        assertSame(bagTwo, newBagTwo);
    }

    @Test
    public void should_not_get_bag_when_get_a_bag_given_receipt_is_invalid() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Receipt receipt = locker.storeBag(bag);
        Bag newBag = locker.getBag(receipt);
        assertSame(bag, newBag);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            locker.getBag(receipt);
        });
        String expectedMessage = "Invalid receipt";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void should_not_get_bag_when_get_a_bag_given_receipt_is_invalid_and_space_has_been_reused() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        Receipt receipt = locker.storeBag(bag);
        Bag newBag = locker.getBag(receipt);
        assertSame(bag, newBag);

        Bag bagOne = new Bag();
        Receipt receiptOne = locker.storeBag(bagOne);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            locker.getBag(receipt);
        });
        String expectedMessage = "Invalid receipt";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

        assertSame(bagOne, locker.getBag(receiptOne));

    }

    @Test
    public void should_get_receipt_when_store_empty_given_the_locker_has_available_space() {
        Locker locker = new Locker(1);

        Receipt receipt = locker.storeBag(null);

        assertNotNull(receipt);
    }

    @Test
    public void should_get_stored_empty_when_get_bag_given_valid_receipt() {
        Locker locker = new Locker(1);

        Receipt receipt = locker.storeBag(null);

        assertSame(null, locker.getBag(receipt));
    }

    @Test
    public void should_get_one_bag_and_one_stored_empty_when_get_bags_given_valid_receipts() {
        Locker locker = new Locker(2);

        Bag bag = new Bag();
        Receipt receiptForEmpty = locker.storeBag(null);
        Receipt receiptForBag = locker.storeBag(bag);

        assertSame(null, locker.getBag(receiptForEmpty));
        assertSame(bag, locker.getBag(receiptForBag));
    }

}
