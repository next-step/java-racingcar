package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
    }

    @DisplayName("Car 이동 표시 확인")
    @ParameterizedTest
    @MethodSource("moveCase")
    void moveOrStopCar(boolean moveOrNot, String result, String carName) {
        Car car = new Car(carName);
        car.move(() -> moveOrNot);
        assertThat(ResultView.printPosition(car)).isEqualTo(carName + ":" + result);
    }

    private static Stream<Arguments> moveCase() {
        return Stream.of(
                Arguments.of(true, "-", "pobi"),
                Arguments.of(false, "", "crong")
        );
    }

    @Test
    @DisplayName("최종 우승자 Car Name 출력")
    void getWinnerTest() {
        assertThat(ResultView.getNamesOfWinnerCarsInString(cars)).isEqualTo("car1,car2,car3");
    }
}