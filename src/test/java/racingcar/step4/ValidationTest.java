package racingcar.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차 이름을 입력하지 않았을 때 예외 처리 하는 테스트")
    void 자동차입력(String str) {
        assertThatThrownBy(() ->
                Validation.checkForNull(str)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 글자 수가 5를 초과 했을 때 예외 처리 하는 테스트")
    void 자동차이름글자수() {
        assertThatThrownBy(() ->
                Validation.isValidCarNames("geonhee,pobi")).isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    @DisplayName("시도 회 수가 1 미만 일 때 예외 처리 하는 테스트")
    void 시도회수예외처리(int count) {
        assertThatThrownBy(() ->
                Validation.checkValidTryCount(count)).isInstanceOf(IllegalArgumentException.class);
    }

}