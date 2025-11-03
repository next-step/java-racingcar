package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @Test
    void Split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void SubString(){
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("result의 인덱스 범위를 벗어나면 IndexOutOfBoundsException발생하는지 예외에 나타나는 숫자까지 테스트")
    void 인덱스_범위_테스트_예외메시지_숫자포함(){
        String result = "abc";
        assertThatThrownBy(() -> {
            result.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("Index 3 out of bounds for length 3");
    }

    @Test
    @DisplayName("result의 인덱스 범위를 벗어나면 IndexOutOfBoundsException발생하는지 테스트")
    void 인덱스_범위_테스트_예외메시지_정규식허용(){
        String result = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    result.charAt(9);
                }).withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }
}
