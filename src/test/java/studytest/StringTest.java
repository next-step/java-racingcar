package studytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("String 클래스의 split 메소드는 구분인자를 기준으로 문자열을 분리하여 문자열 배열을 반환한다")
    public void 테스트_String_split() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).containsOnly("1");
    }

    @Test
    @DisplayName("String 클래스의 substring 메소드는 시작과 끝을 지정하여 문자열을 잘라 반환한다")
    public void 테스트_String_substring() {
        assertThat("(1,2)".substring(1, 4).split(",")).contains("1", "2");
    }

    @Test
    @DisplayName("String 클래스의 charAt 메소드는 전달된 인덱스에 해당하는 요소를 반환한다.")
    public void 테스트_String_charAt() {
        assertThat("abc".charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("String 클래스의 charAt 메소드는 전달된 인덱스가 문자열의 길이를 " +
            "초과하면 IndexOutOfBoundsException 예외가 발생한다")
    public void 테스트_String_charAt_IndexOutOfBoundsException() {
        assertThatThrownBy(() -> "abc".charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
