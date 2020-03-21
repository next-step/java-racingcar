package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {
    private static final int ZERO = 0;
    private static final int NUMBER_OF_CAR = 3;

    @DisplayName("자동차 경주 정상 실행")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7})
    void racingGameExecute(int numberOfTime) {
        RacingGame racingGame = new RacingGame(NUMBER_OF_CAR, new RandomMovingStrategy());
        for (int i = 0; i < numberOfTime; i++) {
            racingGame.execute();
        }

        assertThat(racingGame.getTime()).isEqualTo(numberOfTime);
    }

    @DisplayName("자동자 개수가 1보다 작을 시 생성 실패")
    @Test
    void createFailByNumberOfCar() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame(ZERO, new RandomMovingStrategy()));
    }
}
