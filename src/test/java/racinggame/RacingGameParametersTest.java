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
    }

    @Test
    void 생성자_전부_정상2() {
        int round = 2;
        int carQuantity = 3;

        RacingGameParameters racingGameParameters = new RacingGameParameters(round, carQuantity);

        assertThat(racingGameParameters.getGameRound()).isEqualTo(round);
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
