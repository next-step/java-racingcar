package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split 메서드 문자열 분리 테스트")
    void 요구사항1_split_test() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring 메서드 문자열 자르기 테스트")
    void 요구사항2_substring_test() {
        String data = "(1,2)";
        String bracketDeletedString = data.substring(1, 4);
        assertThat(bracketDeletedString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메서드 예외 테스트")
    void 요구사항3_charAt_test() {
        String data = "abc";
        assertThatThrownBy(() -> {
            data.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("charAt 매개변수가 주어진 문자열 인덱스 범위를 넘어감.");
    }


}
