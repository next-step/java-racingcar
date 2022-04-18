package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest  {
    @Test
    @DisplayName("round가 음수일땐 에러를 뱉는다.")
    void argumentExceptionErrorTest() {
        int carCount = 4;
        int round = -1;

        List<Car> cars = new ArrayList<>();
        for (int number = 0; number < carCount; number++) {
            cars.add(new Car());
        }

        assertThatThrownBy(() -> new RacingCar(cars, round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("round는 음수가 될 수 없습니다");
    }

    @Test
    @DisplayName("입력받은 라운드 보다 더 많은 라운드를 진행할때 에러를 뱉는다.")
    void roundErrorTest() {
        int carCount = 4;
        int round = 4;

        List<Car> cars = new ArrayList<>();
        for (int number = 0; number < carCount; number++) {
            cars.add(new Car());
        }

        RacingCar racingCar = new RacingCar(cars, round);

        for (int currentRound = 0; currentRound < round; currentRound++) {
            racingCar.playRound();
        }

        assertThatThrownBy(racingCar::playRound)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("모든 라운드가 종료 되었습니다.");
    }
}
