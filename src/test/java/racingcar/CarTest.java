package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final String CAR_NAME = "oyeon";
    private static final int MOVE_COUNT = 1;

    @DisplayName("Car 생성 확인")
    @Test
    void constructCar() {
        //given
        Car car = new Car(CAR_NAME, MOVE_COUNT);

        //when
        int moveCount = car.moveCount().value();
        String carName = car.carName().value();

        //then
        assertThat(carName).isEqualTo(CAR_NAME);
        assertThat(moveCount).isEqualTo(MOVE_COUNT);
    }

    @DisplayName("숫자가 4이상이면 전진")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:1", "2:1", "3:1",
            "4:2", "5:2", "6:2", "7:2", "8:2", "9:2"}, delimiter = ':')
    void makeMoveCount(int number, int moveCount) {
        //given
        Car car = new Car(CAR_NAME, MOVE_COUNT);

        //when
        car.move(number);

        //then
        assertThat(car.moveCount().value()).isEqualTo(moveCount);
    }
}