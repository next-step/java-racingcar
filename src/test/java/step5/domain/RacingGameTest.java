package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class RacingGameTest {

    @DisplayName("Arguments check / input negative number to cars count.")
    @ParameterizedTest
    @ValueSource(ints = {-2, -3, -1, -100})
    void testInputCarsCountNegativeNumber(int tryTimes) {

        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    RacingGame racingGame = new RacingGame(new String[]{"any", "test"}, tryTimes);
                }
        );

    }

}
