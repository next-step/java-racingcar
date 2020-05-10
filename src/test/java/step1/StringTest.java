package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Step1. String 클래스에 대한 학습 테스트")
public class StringTest {

    @DisplayName("'1,2' 를 ,로 split 하면 1과 2를 가진 배열을 반환한다")
    @Test
    void stringWithTwoNumberSplitTest() {
        assertThat("1,2".split(","))
                .hasSize(2)
                .contains("1", "2")
                .containsExactly("1", "2");
    }

    @DisplayName("'1'을 ,로 split하면 1을 가진 배열을 반환한다")
    @Test
    void stringWithOneNumberSplitTest() {
        assertThat("1".split(","))
                .hasSize(1)
                .contains("1")
                .containsExactly("1");
    }

    @DisplayName("'(1,2)'를 beginIndex(1) endIndex(4)로 subString하면 '1,2' 문자열을 반환한다")
    @Test
    void stringSubstringTest() {
        assertThat("(1,2)".substring(1, 4))
                .isEqualTo("1,2");
    }

    @DisplayName("String의 charAt() 메서드는 문자열 위치를 벗어나면 StringIndexOutOfBoundsException 예외를 발생시킨다")
    @Test
    void stringCharAtTest() {
        assertThatThrownBy(() -> "abc".charAt(10))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("range: 10");
    }
}
