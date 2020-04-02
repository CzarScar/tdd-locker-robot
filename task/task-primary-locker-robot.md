 ## Primary Locker Robot
 
 * Bags can be stored
    + Given the Locker under the robot has available space
    + When I have a bag
    + Then I can store the bag
 * Bags can be stored in the first available locker
    + Given there are two lockers under the robot and has available space
    + When I have a bag
    + Then I can store the bag in the first available locker
 * Bags cannot be stored in full lockers
    + Given there is no available space in robot's lockers
    + When I have a bag
    + Then I cannot store the bag
 * Valid Receipts can get the stored bags from Robots
    + Given I store the bag in the robots and get receipt
    + When I use the receipt
    + Then I can get the bag
 * Invalid Receipts cannot get bag
    + Given I store the bag in robot's locker
    + When I use an invalid receipts
    + Then I cannot get the bag