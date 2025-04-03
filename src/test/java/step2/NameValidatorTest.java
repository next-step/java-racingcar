package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameValidatorTest {

    @Test
    @DisplayName("자동차 이름의 길이가 5 이하인 경우 테스트")
    void nameLengthTest() {
        String input = "John Doe";
        int maxLength = 5;
        assertThat(input.length()).isLessThanOrEqualTo(maxLength);
    }
}
