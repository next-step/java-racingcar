import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("문자열을 자르면 배열을 반환한다.")
    void split_return_array(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("문자열을 잘라 반환된 배열은 순서를 보장한다.")
    void split_return_ordered_array(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열을 substring() 함수로 처음과 끝을 제거할 수 있다.")
    void substring_first_last(){
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드가 문자열의 인덱스를 벗어나면 OutOfBoundsException을 발생시킨다.")
    void chartAt_bounds_exception(){
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("index out of range");
    }

    @Test
    @DisplayName("예외 메세지를 withMessageMatching() 메소드를 이용해 패턴으로 검증 가능하다.")
    void chartAt_bounds_exception_by_pattern_matching(){
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                "abc".charAt(3);
            }).withMessageMatching("String index out of range: \\d+");
    }
}
