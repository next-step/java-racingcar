package study.step3;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    void 자동차_경주_테스트() {
        int cars = 3;
        int moves = 5;

        System.out.println("자동차 대수는 몇 대 인가요?");
        System.out.println(cars);
        System.out.println("시도할 회수는 몇 회 인가요?");
        System.out.println(moves);

        Racing racing = new Racing(new Random());
        racing.start(new Rule(cars, moves));
    }
}
