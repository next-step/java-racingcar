package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberOfGameTest {
    @Test
    void 입력값확인() {
        NumberOfGame numberOfGame = new NumberOfGame(5);
        Assertions.assertThat(numberOfGame.checkNumberOfGame(5)).isTrue();
    }
}
