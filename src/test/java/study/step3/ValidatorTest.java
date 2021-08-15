package study.step3;

import org.junit.jupiter.api.Test;
import step3.util.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    Validator validator = new Validator();
    final String CAR_COUNT_ERROR = "자동차는 1대 이상이어야 합니다.";
    final String GAME_COUNT_ERROR = "게임 횟수는 1번 이상이어야 합니다.";

    @Test
    void checkInputTest_정상_실행_케이스() {
        validator.checkInput(1, 5);
    }

    @Test
    void checkInputTest_자동차_개수_에러_케이스() {
        assertThatThrownBy(() -> validator.checkInput(0, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_COUNT_ERROR);
    }

    @Test
    void checkInputTest_게임_횟수_에러_케이스() {
        assertThatThrownBy(() -> validator.checkInput(1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GAME_COUNT_ERROR);
    }
}
