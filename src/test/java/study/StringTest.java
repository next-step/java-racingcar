package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void 문자열을_쉼표로_분리하면_배열로_반환된다(){
        // given
        String input = "1,2";

        // when
        String[] output = input.split(",");

        // then
        assertAll(
                () -> assertThat(output).contains("1", "2"),
                () ->  assertThat(output).containsExactly("1", "2")
        );
    }

    @Test
    void 쉼표가_없는_문자열을_쉼표로_분리하면_문자열이_배열로_반환된다(){
        // given
        String input = "1";

        // when
        String[] output = input.split(",");

        // then
        assertAll(
                () -> assertThat(output).contains("1"),
                () -> assertThat(output).containsExactly("1")
        );
    }

    @Test
    void 문자열의_소괄호를_제거한다(){
        // given
        String input = "(1,2)";

        // when
        String output = input.substring(1, input.length()-1);

        // then
        assertThat(output).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 위치 값을 벗어나면 예외를 반환한다")
    void 문자열의_위치_값을_벗어나면_예외를_반환한다(){
        // given
        String input = "abc";

        // when & then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(input.length());
                })
                .withMessageContaining("String index out of range");
    }

}
