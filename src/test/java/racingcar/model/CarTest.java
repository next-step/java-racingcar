package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest(name = "초기 위치 {0}으로 생성된 자동차의 위치는 {0}이어야 한다.")
    @CsvSource({"0", "1", "5"})
    @DisplayName("자동차는 주어진 위치로 초기화된다.")
    void car_initialPosition_test(int initialPosition) {
        Car car = new Car(initialPosition);
        assertThat(car.isAtPosition(new Position(initialPosition))).isTrue();
    }

    @DisplayName("자동차가 이동하면 위치가 올바르게 증가한다.")
    @ParameterizedTest
    @CsvSource({
            "0,4,1",
            "3,3,3",
            "5,6,6",
            "2,9,3",
            "1,0,1"
    })
    void car_move_test(int initialPosition, int randomValue, int expectedPosition) {
        Car car = new Car(initialPosition);

        car.move(randomValue);

        assertThat(car.isAtPosition(new Position(expectedPosition))).isTrue();
    }

    @DisplayName("초기 위치가 5인 자동차가 2번 이동 하면 현재 위치보다 2 증가한다.")
    @ParameterizedTest
    @CsvSource({
            "0,1,1,0",
            "3,4,4,5",
            "5,4,1,6",
            "5,1,5,6"
    })
    void move_initial_move(int initialPosition, int randomValue, int randomValue2, int expectedPosition) {
        Car car = new Car(initialPosition);

        car.move(randomValue);
        car.move(randomValue2);

        assertThat(car.isAtPosition(new Position(expectedPosition))).isTrue();
    }
}
