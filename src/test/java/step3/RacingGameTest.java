package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @ParameterizedTest
    @DisplayName("자동차 갯수와 이동 횟수가 숫자가 아닌 경우 예외")
    @CsvSource(value = {"문자입력중! : 숫자를 입력해주세요."}, delimiter = ':')
    public void 자동차_n개_이동횟수_n개_숫자가_아닌_경우(String value, String message) {
        assertThatThrownBy(() -> assertThat(value)
                .isInstanceOf(IllegalArgumentException.class))
                .overridingErrorMessage(message);
    }

    @Test
    @DisplayName("자동차 수가 0개인 경우 예외")
    public void 자동차수_값이_0인경우() {
        assertThatThrownBy(() -> racingGame.run(0, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이동수가 0개인 경우 예외")
    public void 자동차_이동_값이_0인경우() {
        assertThatThrownBy(() -> racingGame.run(5, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
