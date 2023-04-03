package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래에 대한 학습 테스트")
class StringTest {

    @Test
    @DisplayName("String의 split() 메소드는 특정 문자로 대상문자를 분리합니다.")
    void split() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");
        Assertions.assertAll(
                () -> assertThat(result1).containsExactly("1", "2"),
                () -> assertThat(result2).containsExactly("1")
        );
    }

    @Test
    @DisplayName("String의 substring() 메소드는 특정 문자열의 범위를 가져옵니다.")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt() 메소드는 특정 위치의 문자를 가져옵니다.")
    void charAt() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("String의 charAt 메소드 사용시 문자의 위치값을 벗어나면 StringIndexOutOfBoundsException이 발생합니다.")
    void StringIndexOutOfBoundsExceptionOfCharAt() {
        assertThatThrownBy(() -> "abc".charAt(5)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\d+");

    }
}
