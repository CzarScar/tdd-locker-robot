# Smart Locker Robot

 * Bags can be stored
    + Given the Locker under the smart robot has available space
    + When I store a bag
    + Then I can get the receipt
 * Bags can be stored in the more available space locker
    + Given there are two lockers under the robot and has available space
    + When I store a bag
    + Then I can store the bag in the more available space locker
 * Bags cannot be stored in full lockers
    + Given there is no available space in smart robot's lockers
    + When I store a bag
    + Then I cannot store the bag
 * Bags can be stored in the first locker with same available space
    + Given there are two lockers under the robot and has same available space
    + When I store a bag
    + I can store the bag in the first locker
 * Valid Receipts can get the stored bags from Robots
    + Given I store the bag in the robots and get receipt
    + When I use the receipt
    + Then I can get the bag
 * Invalid Receipts with locker info cannot get bag
    + Given I store the bag in robot's locker
    + When I use an invalid receipts with locker info
    + Then I cannot get the bag
 * Invalid Receipts without locker info cannot get bag
    + Given I store the bag in robot's locker
    + When I use an invalid receipts without locker info
    + Then I cannot get the bag
 * Invalid Receipts with locker position position cannot get bag
    + Given I store the bag in robot's locker
    + When I use an invalid receipts with locker position
    + Then I cannot get the bag
 * Invalid Receipts without locker position position cannot get bag
    + Given I store the bag in robot's locker
    + When I use an invalid receipts without locker position
    + Then I cannot get the bag