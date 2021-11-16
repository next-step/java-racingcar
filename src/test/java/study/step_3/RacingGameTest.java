package study.step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 12})
    @DisplayName("자동차 수 입력 값만큼 자동차를 생성한다")
    void shouldGenerateRacingCarAsMuchAsInput(int numberOfCars) {
        Input input = new Input(numberOfCars, 5);
        RacingGame racingGame = new RacingGame(input);

        assertThat(racingGame.numberOfCars()).isEqualTo(numberOfCars);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 9})
    @DisplayName("시도할 횟수 입력 값만큼 게임을 수행한다")
    void shouldMoveAsMuchAsInput(int numberOfTrial) {
        Input input = new Input(3, numberOfTrial);
        RacingGame racingGame = new RacingGame(input);

        assertThat(racingGame.numberOfTrial()).isEqualTo(numberOfTrial);
    }
}