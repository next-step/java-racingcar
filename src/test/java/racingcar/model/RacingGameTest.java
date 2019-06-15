package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {

    @Test
    void gameGenerator() {
        int time = 5;
        int carCount = 3;
        RacingGame game = RacingGame.of(time, carCount);
        assertThat(game.getTime()).isEqualTo(time);
        assertThat(game.getCars().size()).isEqualTo(carCount);
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 1",
            "1,  -1",
            "-1, -1"
    })
    void gameGeneratorWhenNegativeInputThenFail(int time, int carCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingGame.of(time, carCount));
    }

    @Test
    void carMove() {
        carMove();
    }
}