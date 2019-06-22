package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingGameParametersTest {
    private String carNameString = "pobi,crong,honux";
    private int carQuantity = 3;
    private MoveDecider moveDecider = new MoveDecider() {
        @Override
        public boolean canMove() {
            return true;
        }
    };

    @Test
    void 생성자_전부_정상() {
        int round = 2;

        RacingGameParameters racingGameParameters = new RacingGameParameters(round, carNameString, moveDecider);

        assertThat(racingGameParameters.getCarQuantity()).isEqualTo(carQuantity);
        assertThat(racingGameParameters.getGameRound()).isEqualTo(round);
    }

    @Test
    void 생성자_round_비정상() {
        int round = 0;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingGameParameters(round, carNameString, moveDecider));
    }

    @Test
    void 생성자_carQuantity_비정상() {
        int round = 2;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingGameParameters(round, "", moveDecider));
    }
}
