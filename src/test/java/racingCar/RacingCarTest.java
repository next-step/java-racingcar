package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static java.lang.System.lineSeparator;
import static java.lang.System.setIn;
import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    @Test
    void 게임테스트(){
        String userInput = String.format("3%s5", lineSeparator(), lineSeparator());
        setIn(new ByteArrayInputStream(userInput.getBytes()));
        RacingCarMain.main(null);
    }

    @Test
    void 전진유효값(){
        StartGame startGame = new StartGame();
        assertThat(startGame.validationAdvance(4)).isTrue();
        assertThat(startGame.validationAdvance(3)).isFalse();
        assertThat(startGame.validationAdvance(2)).isFalse();
        assertThat(startGame.validationAdvance(1)).isFalse();
        assertThat(startGame.validationAdvance(0)).isFalse();
    }


}
