package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingGameParametersTest {
    @Test
    void 생성자_전부_정상() {
        int round = 2;
        int carQuantity = 3;

        RacingGameParameters racingGameParameters = new RacingGameParameters(round, carQuantity);

        assertThat(racingGameParameters.getCarQuantity()).isEqualTo(carQuantity);
        assertThat(racingGameParameters.getGameRound()).isEqualTo(round);
        assertThat(racingGameParameters.isFinished()).isFalse();
    }

    @Test
    void 생성자_round_비정상() {
        int round = 0;
        int carQuantity = 3;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingGameParameters(round, carQuantity));
    }

    @Test
    void 생성자_carQuantity_비정상() {
        int round = 2;
        int carQuantity = 0;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingGameParameters(round, carQuantity));
    }

    @Test
    void 게임_라운드를_초과하면_isFinished_함수는_true_반환() {
        RacingGameParameters racingGameParameters = new RacingGameParameters(2, 1);

        assertThat(racingGameParameters.isFinished()).isFalse();
        racingGameParameters.increaseCurrentRound();
        assertThat(racingGameParameters.isFinished()).isFalse();
        racingGameParameters.increaseCurrentRound();
        assertThat(racingGameParameters.isFinished()).isTrue();
    }

    @Test
    void 라운드가_끝났을때_increaseCurrentRound_호출시_에러() {

        RacingGameParameters racingGameParameters = new RacingGameParameters(1, 1);
        racingGameParameters.increaseCurrentRound();
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(racingGameParameters::increaseCurrentRound);
    }
}
