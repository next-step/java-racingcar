package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest  {
    @Test
    @DisplayName("게임을 생성한다")
    void createGame() {
        int carCount = 4;
        int round = 4;

        List<Car> cars = new ArrayList<>();
        for (int number = 0; number < carCount; number++) {
            cars.add(new Car());
        }

        RacingCar racingCar = new RacingCar(cars, round, new ResultView());

        assertThat(racingCar.playRacing()).isEqualTo(round);
    }

    @Test
    @DisplayName("round가 음수일땐 에러를 뱉는다.")
    void VariableRoundWillBeNotNegative() {
        int carCount = 4;
        int round = -1;

        List<Car> cars = new ArrayList<>();
        for (int number = 0; number < carCount; number++) {
            cars.add(new Car());
        }

        assertThatThrownBy(() -> {
            new RacingCar(cars, round, new ResultView());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
