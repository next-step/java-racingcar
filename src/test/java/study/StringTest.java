package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("주어진 문자열(콤마 포함)이 콤마로 문자열 배열로 분리되는지 확인")
    void split() {
        // 요구사항1-1
        String str = "1,2";
        String[] result = str.split(",");

        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("주어진 문자열이(콤마 미포함)이 콤마로 문자열 배열로 분리되는지 확인")
    void split1() {
        // 요구사항1-2
        String str = "1";
        String[] result = str.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("주어진 문자열에 ( , )을 제거후 ( , )가 빠진 문자열인지 확인")
    void substring() {
        // 요구사항2
        String str = "(1,2)";
        String result = str.substring(1,4);

        assertThat(result).contains("1,2");

    }

    @Test
    @DisplayName("abc 문자열에서 특정 위치의 문자를 확인")
    void charAt() {
        // 요구사항3
        String str = "abc";
        char result1 = str.charAt(0);
        char result2 = str.charAt(1);
        char result3 = str.charAt(2);

        assertThat(result1).isEqualTo('a');
        assertThat(result2).isEqualTo('b');
        assertThat(result3).isEqualTo('c');

        assertThatThrownBy(() -> {
            str.charAt(4);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 4, Size: 4");


    }
}
