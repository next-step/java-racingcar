package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1"); // assertThat이라는 라이브러리를 이용해서, data에 내가 원하는 값이 있는지 확인한다. 배열, Collection 쓸 때 많이 사용한다.
        assertThat(result).containsExactly("1", "2"); //containsExactly : 해당 순서로 값이 잘 들어있는지까지 확인
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String result = "(1,2)".substring(1, value.length() - 1); // 숫자를 명시적으로 하고싶지 않다.
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져온다.")
    void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
