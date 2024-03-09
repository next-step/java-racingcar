package racingcar.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.step3.move.IncrementMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @DisplayName("전략에 따라 move 횟수만큼 이동하거나 멈춘다.")
    @ParameterizedTest
    @CsvSource(value = {"4:4", "5:5", "9:9"}, delimiter = ':')
    void stopCarWhenSignBetweenZeroToThree(int repeatCount, int currentLocation) {
        // given
        car = new Car(new IncrementMoveStrategy());

        // when
        for (int i = 0; i < repeatCount; i++) {
            car.move();
        }

        // then
        assertThat(car.getCurrentLocation()).isEqualTo(currentLocation);
    }
}