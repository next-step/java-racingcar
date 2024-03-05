package string;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void step1_requirement1() {
        // Given
        String existComma = "1,2";
        String nonExistComma = "1";

        // When & Then
        assertThat(existComma.split(",")).contains("1","2");
        assertThat(nonExistComma.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("문자열에서 존재하지 않는 index 에 접근하면 예외가 발생한다.")
    void step1_requirement3() {
        // Given
        String target = "abc";

        // When & Then
        assertThatThrownBy(() -> target.charAt(target.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
