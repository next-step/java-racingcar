package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MockGenerator;
import racingcar.util.MockGenerator.CarState;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.CarsTest.carList;
import static racingcar.util.MockGenerator.CarState.MAINTAIN;
import static racingcar.util.MockGenerator.CarState.RUN;

public class RacingCarTest {

    @Test
    @DisplayName("경기 횟수와 참가하는 자동차를 받는다")
    void generate() {
        int time = 0;
        int carCount = 3;
        RacingCar.generate(time, carCount);
    }

    @Test
    @DisplayName("2번째 레이싱 결과를 반환한다")
    void racing() {
        int time = 2;
        int carCount = 2;
        RacingCar racingCar = of(time, carCount, MAINTAIN, RUN, RUN, RUN);

        for (int i = 0; i < time; i++) {
            racingCar.racing();
        }
        List<Car> result = racingCar.getResult();

        assertThat(result.get(0).getPosition()).isEqualTo(2);
        assertThat(result.get(1).getPosition()).isEqualTo(3);
    }

    private RacingCar of(int time, int carCount, CarState... carStates) {
        MockGenerator numberGenerator = MockGenerator.generate(carStates);
        Cars cars = new Cars(carList(carCount), numberGenerator);
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
