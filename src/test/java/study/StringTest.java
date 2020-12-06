package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2 값을 split method로 분리하는 테스트 코드")
    void split() {
        assertThat("1,2".split(",")).containsExactly("1","2");
    }

    @Test
    @DisplayName("(1,2) 값을 substring method로 잘라 1,2 값이 나오는지 확인하는 테스트 코드")
    void substring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt method를 통해 특정 위치 문자 체크하는 ㅌ테스트 코드")
    void charAt() {
        String value = "abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String array 길이를 벗어났을 때 exception 확인하는 테스트 코드")
    void charAt_indexOutBoundsException() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
