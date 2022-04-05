package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void name() {
        //Alt + Insert => Test Method 로 생성
    }
    
    
    @Test
    void split() {
        String[] result = "1,2".split(",");
        //assertThat() 이후에 임포트 static으로 편하게 하는 방법

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");//보다 정확한 순서로 확인하고 싶을 때
        
    }

    @Test
    void subString() {
        String input = "(1,2)";
        String output = input.substring(1, input.length()-1);//파이썬처럼 두번째 인자가 열린구간임.
        assertThat(output).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 i 인덱스의 문자값을 얻기")
    void chartAt() {
        String input = "abc";
        char c = input.charAt(0);

        assertThat(c).isEqualTo('a');
    }

    @Test
    @DisplayName("위치값 벗어나는 경우1")
    void chartAtWithException1() {
        //https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion
        //AssertJ Exception Assertions 문서링크가 막연해보이는데 영문도 많고,, 멘토님은 어떻게 학습하시는지 궁금

        assertThatThrownBy(() -> {
            throw new StringIndexOutOfBoundsException("Index: 2, Size: 2");
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");

    }

    @Test
    @DisplayName("위치값 벗어나는 경우2")
    void chartAtWithException2() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    throw new StringIndexOutOfBoundsException("Index: 2, Size: 2");
                }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
}
