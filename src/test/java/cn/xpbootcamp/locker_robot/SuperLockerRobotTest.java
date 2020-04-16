package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperLockerRobotTest {

    @Test
    public void should_get_a_receipt_when_store_a_bag_given_super_locker_robot_with_lockers(){
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(new int[]{1, 2, 3});
        Bag bag = new Bag();

        Receipt receipt = superLockerRobot.storeBag(bag);

        assertNotNull(receipt);
    }
}
