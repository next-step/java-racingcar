package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("split 분리 확인 테스트 1")
    @Test
    void split1() {

        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("split 분리 확인 테스트 2")
    @Test
    void split2() {

        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("substring 반환 테스트")
    @Test
    void substring() {

        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져오는 테스트")
    @Test
    void charAt1() {

        char result = "abc".charAt(2);
        assertThat(result).isEqualTo('c');

    }

    @DisplayName("StringIndexOutOfBoundsException이 발생 테스트")
    @Test
    void charAt2() {

        String str = "abc";
        int strSize = str.length();
        int index = 3;

        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + strSize);
    }
}
