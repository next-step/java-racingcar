package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class ToolTest {

    @RepeatedTest(value = 50, name = "{displayName} [{currentRepetition}/{totalRepetitions}]")
    @DisplayName("0~9 사이 정수를 생성한다.")
    void makeRandomNumber() {
        int number = Tool.makeRandomNumber();
        assertThat(number).isGreaterThanOrEqualTo(0);
        assertThat(number).isLessThanOrEqualTo(9);
    }
}
