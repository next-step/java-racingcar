package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split1() {
        final String[] actual = "1,2".split(",");
        // actual contains [1, 2]
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    // "(1,2)" 값이 주어졌을 때 String의 ??? 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    @Test
    void substring() {
//        String actual = "(1,2)".replace("(", "")
//                               .replace(")", "");
        String actual = "(1,2)".substring(1, "(1,2)".length()-1);
        assertThat(actual).isEqualTo("1,2");
    }

    // "abc" 값이 주어졌을 때 String의 ??? 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    // String의 ??? 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    // JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    @Test
    void charAt() {
        final char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo('c');
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외가 발생한다.")
    @Test
    void charAt2() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }

}
