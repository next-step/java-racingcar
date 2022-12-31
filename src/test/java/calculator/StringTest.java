package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import caculator.StringSupport;

class StringTest {

    public static final String DELIMITER = ",";

    @Test
    @DisplayName(",로 연결된 숫자 문자열이 잘 분리되는지 확인한다.")
    void test_split_numbers() {
        final String[] actual = StringSupport.of("1,2").split(DELIMITER);
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("단일 문자열이 잘 분리되는지 확인한다.")
    void test_split_number() {
        final String[] actual = StringSupport.of("1").split(DELIMITER);
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("String 의 substring() 메소드를 활용해 ()을 제거하고 문자열을 반환한다.")
    void test_substring() {
        final String given = "(1,2)";
        assertThat(given.substring(1, given.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다. "
            + "범위에 벗어나는 경우 StringIndexOutOfBoundsException 이 발생한다.")
    void test_charAt() {
        final String given = "abc";
        final int when = given.length();

        assertThat(given.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> given.charAt(when))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %d", when);

    }
}