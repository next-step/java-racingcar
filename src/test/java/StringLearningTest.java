import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringLearningTest {

    @DisplayName("string을 , 기준으로 split했을 때 성공적으로 나눠진다.")
    @Test
    void split_StringNumberGiven_SuccessSplit() {
        // given
        String number = "1,2";

        // when
        String[] splittedNumber = number.split(",");

        // then
        assertThat(splittedNumber).contains("1", "2");
    }

    @DisplayName("하나의 문자인 String을 split했을 때도 배열이 반환된다.")
    @Test
    void split_StringGiven_ShouldReturnArray() {
        // given, when
        String[] split = "1".split(",");

        // then
        assertThat(split).containsExactly("1");
    }

    @DisplayName("String의 substring()을 배운다.")
    @Test
    void substring_StringGiven_ShouldRemoveBracket() {
        // given, when, then
        assertThat("(1,2)".substring(1).substring(0, 3)).isEqualTo("1,2");
    }

    @DisplayName("String의 charAt()을 배운다.")
    @Test
    void charAt_StringGiven_ShouldThrowIndexOutOfException() {
        // given, when, then
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");
    }
}
