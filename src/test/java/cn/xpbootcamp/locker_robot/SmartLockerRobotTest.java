package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartLockerRobotTest {

    @Test
    public void should_get_receipt_when_store_a_bag_given_locker_under_smart_locker_robot_has_available_space(){
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(1,1);
        Bag bag = new Bag();
        Receipt receipt = smartLockerRobot.storeBag(bag);
        assertNotNull(receipt);
    }
}
