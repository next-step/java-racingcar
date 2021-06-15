package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    private Cars cars = new Cars();

    @ParameterizedTest
    @ValueSource(strings = {"현진,진현"})
    public void 레이싱게임_객체생성(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.addCars(carName);
        }

        RacingGame racingGame = new RacingGame(cars, 5);
        assertThat(racingGame).isInstanceOf(RacingGame.class);
    }

    @Test
    public void 레이싱게임_시작() {
        RacingGame racingGame = new RacingGame(cars, 5);
        racingGame.race();

        assertThat(true).isEqualTo(racingGame.isEnd());
    }
}
