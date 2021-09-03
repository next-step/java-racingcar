package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.util.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    Validator validator = new Validator();
    private final String CAR_COUNT_ERROR = "자동차 이름은 한개 이상 입력 되어야 합니다.";
    private final String GAME_COUNT_ERROR = "게임 횟수는 1번 이상이어야 합니다.";
    private final String NAME_LENGTH_MIN_ERROR = "자동차 이름은 1자 이상이어야 합니다.";
    private final String NAME_LENGTH_MAX_ERROR = "자동차 이름은 5자 이하여야 합니다.";

    String[] names = {"pobi"};

    @DisplayName("게임 횟수 검증 정상 케이스")
    @Test
    void checkGameCountTest_게임_횟수_5() {
        validator.checkGameCount(5);
    }

    @DisplayName("게임 횟수 검증 에러 케이스")
    @Test
    void checkInputTest_게임_횟수_0() {
        assertThatThrownBy(() -> validator.checkGameCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GAME_COUNT_ERROR);
    }

    @DisplayName("자동차명 배열이 null일 때 에러 케이스")
    @Test
    void checkInputTest_자동차명_null_에러_케이스() {
        String[] names = new String[0];
        assertThatThrownBy(() -> validator.checkNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_COUNT_ERROR);
    }

    @DisplayName("자동차명 배열 사이즈가 0일 때 에러 케이스")
    @Test
    void checkInputTest_자동차명_배열_0_에러_케이스() {
        assertThatThrownBy(() -> validator.checkNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_COUNT_ERROR);
    }

    @DisplayName("자동차명이 빈 값일 때 에러 케이스")
    @Test
    void checkInputTest_자동차명_빈값_에러_케이스() {
        String[] emptyName = {"pobi", ""};
        assertThatThrownBy(() -> validator.checkNames(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_LENGTH_MIN_ERROR);
    }

    @DisplayName("자동차명 길이가 5 이상일 때 에러 케이스")
    @Test
    void checkInputTest_자동차명_길이_5이상_에러_케이스() {
        String[] longName = {"pobipobi"};
        assertThatThrownBy(() -> validator.checkNames(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_LENGTH_MAX_ERROR);
    }

}
