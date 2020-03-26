public class Locker {
  
  @Test
  public void bag_stored_when_locker_has_space() {
    Locker locker = new Locker();
    Bag bag = new Bag();

    locker.set_empty();
    Assert(locker.has_space());

    Receipt receipt = locker.store(bag);
    AssertNotNull(receipt);
  }

  @Test
  public void bag_stored_when_locker_is_full() {
    Locker locker = new Locker();
    Bag bag = new Bag();

    locker.set_full();
    Assert(locker.is_full());

    Receipt receipt = locker.store(bag);
    AssertNull(receipt);
  }

  @Test
  public void valid_receipt_to_get_bag() {
    Locker locker = new Locker();
    Receipt receipt = new Receipt();

    receipt.set_valid();
    Assert(receipt.is_valid());

    Bag bag = locker.get(receipt);
    AssertNotNull(bag);
  }
  
  @Test
  public void invalid_receipt_to_get_bag() {
    Locker locker = new Locker();
    Receipt receipt = new Receipt();

    receipt.set_invalid();
    Assert(receipt.is_invalid());

    Bag bag = locker.get(receipt);
    AssertNull(bag);
  }
}
