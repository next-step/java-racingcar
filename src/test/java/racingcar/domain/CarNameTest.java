package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameTest {
    @DisplayName("자동차 이름이 5자리 이상이면 에러")
    @Test
    void checkNameValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("aaaaaa"));
    }
}
