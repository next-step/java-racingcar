package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    @DisplayName("String 의 split 함수 테스트")
    void split() {
        String[] result = "1,2".split(",");

        // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트
        assertThat(result).containsExactly("1", "2");

        //"1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("String 의 substring 함수 테스트")
    void substring() {
        // (1,2)" 값이 주어졌을 때 String 의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현
        String result = "(1,2)";
        assertThat(result.substring(
                1,
                result.length() - 1
        )).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 의 charAt 함수 테스트")
    void charAt() {
        String abc = "abc";

        // "abc" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트
        assertThat(abc.charAt(0))
                .isEqualTo('a');
        assertThat(abc.charAt(1))
                .isEqualTo('b');
        assertThat(abc.charAt(2))
                .isEqualTo('c');

        // String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트
        assertThatThrownBy(() -> {
            abc.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    abc.charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}
