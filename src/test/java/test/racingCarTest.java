package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.Calculator;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.RacingGame;

public class racingCarTest {

    @Test
    void racingTest() {
//        System.setIn(new ByteArrayInputStream("pobi,woni,jun\n5".getBytes()));
        RacingGame racingGame = new RacingGame("pobi,woni,jun", 5);
        racingGame.race();
    }

    @Test
    void racingInputLengthErrorTest() {
//        System.setIn(new ByteArrayInputStream("pobi,woni,november\n5".getBytes()));
        AssertionsForClassTypes.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                RacingGame racingGame = new RacingGame("pobi,woni,november", 5);
                racingGame.race();
            }).isInstanceOf(IllegalArgumentException.class)
            .withMessageMatching(".*초과할 수 없습니다.+.*");
    }
    @DisplayName("자동차는 이름을 가진다.")
    @Test
    void hasName(String input) {
        RacingGame racingGame = new RacingGame("pobi,woni,jun", 5);
        racingGame.race();
//        assertThat(calc.calculator(input)).isEqualTo(0);
    }
}
