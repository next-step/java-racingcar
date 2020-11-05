package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import racingcar.domain.Car;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @DisplayName("Car 자동차 이동 표시 확인")
    @ParameterizedTest
    @MethodSource("moveCase")
    void moveOrStopCar(boolean moveOrNot, String result) {
        Car car = new Car();
        car.move(() -> moveOrNot);
        assertThat(ResultView.printPosition(car)).isEqualTo(result);
    }

    private static Stream<Arguments> moveCase() {
        return Stream.of(
                Arguments.of(true, "-"),
                Arguments.of(false, "")
        );
    }

}
