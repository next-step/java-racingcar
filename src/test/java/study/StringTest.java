package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("요구사항 1: 1,2 를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인 및 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void req1() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("요구사항 2: (1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현")
    void req2() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3: charAt() 메소드를 활용해 특정 위치의 문자를 가져오도록 구현 및 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException")
    void req3() {
        // given
        String str = "abc";
        int bigIndex = str.length() + 999;

        assertThatThrownBy(() -> {
            // when
            str.charAt(bigIndex);
        })  // then
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + (bigIndex));
    }
}
