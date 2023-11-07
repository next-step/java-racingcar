package study.step3;

import java.util.Random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingTest {

    @ParameterizedTest(name = "자동차_경주_입력_실패_테스트")
    @CsvSource(value = {
        "1:5",
        "2:0",

    }, delimiter = ':')
    void 자동차_경주_입력_실패_테스트(int cars, int moves) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        System.out.println(cars);
        System.out.println("시도할 회수는 몇 회 인가요?");
        System.out.println(moves);

        Assertions.assertThatExceptionOfType(RacingException.class)
            .isThrownBy(() -> new Rule(cars, moves))
            .withMessageContaining("RuleValidationError");
    }

    @Test
    void 자동차_경주_랜덤값_테스트() {
        int cars = 3;
        int moves = 5;

        System.out.println("자동차 대수는 몇 대 인가요?");
        System.out.println(cars);
        System.out.println("시도할 회수는 몇 회 인가요?");
        System.out.println(moves);

        Racing racing = new Racing(new Random());
        racing.start(new Rule(cars, moves));
    }

    @Test
    void 자동차_경주_항상_전진_테스트() {
        int cars = 3;
        int moves = 5;
        System.out.println("자동차 대수는 몇 대 인가요?");
        System.out.println(cars);
        System.out.println("시도할 회수는 몇 회 인가요?");
        System.out.println(moves);

        Racing racing = new Racing(new AlwaysReturn4());
        racing.start(new Rule(cars, moves));
    }

    @Test
    void 자동차_경주_항상_정지_테스트() {
        int cars = 3;
        int moves = 5;
        System.out.println("자동차 대수는 몇 대 인가요?");
        System.out.println(cars);
        System.out.println("시도할 회수는 몇 회 인가요?");
        System.out.println(moves);

        Racing racing = new Racing(new AlwaysReturn1());
        racing.start(new Rule(cars, moves));
    }

    static class AlwaysReturn4 extends Random {

        @Override
        public int nextInt(int bound) {
            return 4;
        }
    }

    static class AlwaysReturn1 extends Random {

        @Override
        public int nextInt(int bound) {
            return 1;
        }
    }
}
