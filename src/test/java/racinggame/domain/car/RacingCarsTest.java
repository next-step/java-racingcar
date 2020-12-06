package racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.move.RandomMoveEx;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @DisplayName("입력한 자동차 수만큼 Car 객체가 생성되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"2:2", "3:3"}, delimiter = ':')
    void checkSize(int carCount, int expected) {
        RacingCars racingCars = new RacingCars(carCount);
        assertThat(racingCars.getRacingCars().size()).isEqualTo(expected);
    }

    @DisplayName("모든 자동차 이동했을 경우 각 자동차의 위치가 증가했는지 확인.")
    @Test
    void move() {
        RacingCars racingCars = new RacingCars(2);
        racingCars = racingCars.move(new RandomMoveEx());
        racingCars.getRacingCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
    }
}