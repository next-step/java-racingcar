package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Constant;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @Test
    @DisplayName("음수 또는 0을 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void validate_carNo() {
        List<Car> cars = new ArrayList<>();
        RacingGame racingGame = new RacingGame(cars, 5);
        assertThatThrownBy(() -> racingGame.validateInput(0, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NUMBER_VALIDATION_ERROR);
    }

    @Test
    @DisplayName("음수 또는 0을 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void validate_chanceNo() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(0));
        cars.add(new Car(1));
        RacingGame racingGame = new RacingGame(cars, 0);
        assertThatThrownBy(() -> racingGame.validateInput(10, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CHANCE_NUMBER_VALIDATION_ERROR);
    }

    @Test
    @DisplayName("자동차 게임을 진행하면 자동차가 위치가 이동된다")
    void play() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(0));
        cars.add(new Car(1));

        RacingGame racingGame = new RacingGame(cars, 5);
        racingGame.play();
        assertThat(cars.get(0).getPosition() > 1);
        assertThat(cars.get(1).getPosition() > 1);
    }
}
