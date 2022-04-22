package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.pattern.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {
    @Test
    @DisplayName("round가 음수일땐 에러를 뱉는다.")
    void argumentExceptionErrorTest() {
        int round = -1;

        Cars cars = Cars.createCars("green,so");
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        assertThatThrownBy(() -> new RacingCar(cars, round, randomNumberGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("round는 음수가 될 수 없습니다");
    }

    @Test
    @DisplayName("입력받은 라운드 보다 더 많은 라운드를 진행할때 에러를 뱉는다.")
    void roundErrorTest() {
        int carCount = 4;
        int round = 4;

        Cars cars = Cars.createCars("green,so");
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingCar racingCar = new RacingCar(cars, round, randomNumberGenerator);

        for (int currentRound = 0; currentRound < round; currentRound++) {
            racingCar.playRound();
        }

        assertThatThrownBy(racingCar::playRound)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("모든 라운드가 종료 되었습니다.");
    }
}
