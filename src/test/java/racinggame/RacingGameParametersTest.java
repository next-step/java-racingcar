package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingGameParametersTest {
    private String carNameString = "pobi,crong,honux";
    private int carQuantity = 3;

    @Test
    void 생성자_전부_정상() {
        int round = 2;

        RacingGameParameters racingGameParameters = new RacingGameParameters(round, carNameString);

        assertThat(racingGameParameters.getCarQuantity()).isEqualTo(carQuantity);
    }

    @Test
    void 생성자_전부_정상2() {
        int round = 2;

        RacingGameParameters racingGameParameters = new RacingGameParameters(round, carNameString);

        assertThat(racingGameParameters.getGameRound()).isEqualTo(round);
    }

    @Test
    void 생성자_round_비정상() {
        int round = 0;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingGameParameters(round, carNameString));
    }

    @Test
    void 생성자_carQuantity_비정상() {
        int round = 2;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingGameParameters(round, ""));
    }

    @Test
    void numberGenerator를_직접_주입() {
        NumberGenerator numberGenerator = new NumberGenerator() {
            @Override
            public int generate() {
                return 3;
            }
        };
        RacingGameParameters.setNumberGenerator(numberGenerator);
        assertThat(CarHandler.getRandomMoveCondition()).isFalse();
    }
}
