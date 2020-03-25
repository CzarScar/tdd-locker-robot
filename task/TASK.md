# Locker Robot Tasking

```
Bag
Locker available or full
Receipt Valid or Invalid
```

* Bags can be stored when Locker has available space.
    + Given the Locker has available space
    + When I have a bag
    + Then I can store the bag and get the receipt
* Bags cannot be stored when Locker is full.
    + Given the locker is full
    + When I have a bag
    + Then I cannot store the bag
* Valid Receipts can get bags from Locker.
    + Given I have a valid receipt
    + When I use the receipt on the locker
    + Then I can get my bag
* Invalid Receipts cannot be used to get bags from Locker.
    + Given I have an invalid receipt
    + When I use the invalid receipt on the locker
    + Then I cannot get a bag
