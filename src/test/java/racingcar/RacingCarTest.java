package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @ParameterizedTest
    @MethodSource("randomNum")
    @DisplayName("자동차가 이동하는 값이 4 이상일 경우에만 전진하고 그렇지않으면 멈춰있는지 확인")
    void carMovesOrStopsByRandomNum(int num) {
        Car car = new Car();
        car.moveCar(num);

        System.out.println("num :: " + num);
        if (num >= 4) {
            assertThat(car.getCurrentPosition()).isEqualTo(1);
            return;
        }
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }

    static IntStream randomNum() {
        Random random = new Random();
        return IntStream.generate(() -> random.nextInt(10)).limit(1);
    }
}
