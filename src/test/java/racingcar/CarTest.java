package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("숫자가 4이상이면 전진")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:1", "2:1", "3:1",
            "4:2", "5:2", "6:2", "7:2", "8:2", "9:2"}, delimiter = ':')
    void makeMoveCount(int number, int moveCount) {
        //given
        Car car = new Car("oyeon", 1);

        //when
        car.makeMoveCount(number);

        //then
        assertThat(car.moveCount().value()).isEqualTo(moveCount);
    }
}