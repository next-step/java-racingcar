package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("초기 위치가 5인 자동차가 2번 이동 하면 현재 위치보다 2 증가한다.")
    @ParameterizedTest
    @CsvSource({
            "0,1,1,0",
            "3,4,4,5",
            "5,4,1,6",
            "5,1,5,6"
    })
    void move_initial_move(int initialPosition, int randomValue, int randomValue2, int expectedPosition) {
        String carName = "car";
        Car initialCar = new Car(carName, new Position(initialPosition));

        Car movedOnceCar = initialCar.move(randomValue);
        Car movedTwiceCar = movedOnceCar.move(randomValue2);

        assertThat(movedTwiceCar.isAtPosition(new Position(expectedPosition))).isTrue();
    }

}
