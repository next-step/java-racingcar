package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCycleRunnerTest {

    @RepeatedTest(10)
    @DisplayName("사이클 테스트")
    void runCycle() {
        CarCycleRunner.runCycle(CarMovement.isCarGoingForward(), new CarMovementLogger());
        /*TODO:System.out 테스트는 어떻게 진행하면 좋을까*/
    }
}