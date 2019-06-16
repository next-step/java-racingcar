package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MockGenerator;
import racingcar.util.MockGenerator.CarState;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.CarsTest.generateCarList;
import static racingcar.util.MockGenerator.CarState.RUN;

public class RacingCarTest {

    @Test
    @DisplayName("레이싱을 한번 진행한 결과를 반환한다")
    void racing() {
        int time = 1;
        int carCount = 2;
        RacingCar racingCar = of(time, carCount, RUN);

        List<Car> result = racingCar.racing();

        assertThat(result).extracting(Car::getPosition).contains(2);
    }

    private RacingCar of(int time, int carCount, CarState carStates) {
        Cars cars = new Cars(generateCarList(carCount), MockGenerator.generate(carStates));
        return new RacingCar(time, cars);
    }

    @Test
    @DisplayName("횟수가 0이면 게임종료")
    void timeZeroThenGameOver() {
        RacingCar racingCar = RacingCar.generate(0, 3);
        assertThat(racingCar.isGameOver()).isTrue();
    }

    @Test
    @DisplayName("횟수가 0이 아닐 시 게임진행")
    void timeNoZeroThenGameOver() {
        RacingCar racingCar = RacingCar.generate(3, 3);
        assertThat(racingCar.isGameOver()).isFalse();
    }
}
