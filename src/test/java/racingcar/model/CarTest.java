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

    @DisplayName("랜덤 값이 4이상 이면 이동한다.")
    @ParameterizedTest
    @CsvSource({
            "0,4,1",
            "3,5,4",
            "5,6,6",
            "2,7,3",
            "2,8,3",
            "1,9,2"
    })
    void car_move_test(int initialPosition, int randomValue, int expectedPosition) {
        Car car = new Car(initialPosition);

        car.move(randomValue);

        assertThat(car.isAtPosition(new Position(expectedPosition))).isTrue();
    }

    @DisplayName("랜덤 값이 3이하 이면 이동하지 않는다.")
    @ParameterizedTest
    @CsvSource({
            "0,3,0",
            "3,2,3",
            "5,1,5",
            "2,0,2",
    })
    void car_not_move_test(int initialPosition, int randomValue, int expectedPosition) {
        Car car = new Car(initialPosition);

        car.move(randomValue);

        assertThat(car.isAtPosition(new Position(expectedPosition))).isTrue();
    }
}
