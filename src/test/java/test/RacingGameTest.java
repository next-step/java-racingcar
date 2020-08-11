package test;

import core.RacingGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import static org.assertj.core.api.Assertions.*;


public class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {-1})
    void checkInputValue(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.checkInputValue(input);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void move(int input) {
        String result = RacingGame.compareRandNum(input);;
        assertThat(result).isEqualTo("");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void stop(int input) {
        String result = RacingGame.compareRandNum(input);
        assertThat(result).isEqualTo("-");
    }


}
