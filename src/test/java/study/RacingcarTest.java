package study;

import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingcarTest {

    @Test
    void racingCar() {

        Racing racing = new Racing();

        String input = "a1,a2,a3,a4,a5";
        int count = 3;

        racing.startRacing(input, count);
    }
}
