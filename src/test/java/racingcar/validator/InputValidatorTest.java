package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputValidatorTest {

    @DisplayName("validate() 테스트 : 실패케이스 -> 자동차이름 5글자 초과한다면 에러 발생")
    @Test
    void validator() {
        String carName = "woojin,woong,hwi";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputValidator.validate(carName);
        });

    }
}
