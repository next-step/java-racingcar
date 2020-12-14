package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    @Test
    @DisplayName("조건 5자리 초과")
    void validateOutOfLength() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name("조건자리조촤");
        })
                .withMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
