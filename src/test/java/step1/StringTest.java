package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringTest {

    @Test
    @DisplayName("split() 메소드는 특정 기준으로 문자열을 분리하여 반환한다.")
    public void requirement1_1() {
        // given
        String testString = "1,2";

        // when
        String[] actual = testString.split(",");

        // then
        assertThat(actual[0]).isEqualTo("1");
        assertThat(actual[1]).isEqualTo("2");
    }

    @Test
    @DisplayName("split() 메소드는 분리 기준이 문자열에 포함되어 있지 않은 경우 원래 문자열을 그대로 반환한다.")
    public void requirement1_2() {
        // given
        String testString = "1";

        // when
        String[] actual = testString.split(",");

        // then
        assertThat(actual).isEqualTo(new String[]{"1"});
    }

    @Test
    @DisplayName("substring() 메소드는 문자열의 일부를 잘라 반환한다.")
    public void requirement2() {
        // given
        String testString = "(1,2)";

        // when
        String actual = testString.substring(1, 4);

        // then
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드는 특정 위치의 문자를 반환한다.")
    public void requirement3_1() {
        // given
        String testString = "abc";

        // when
        Character actual = testString.charAt(0);

        // then
        assertThat(actual).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt() 메소드는 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외를 반환한다.")
    public void requirement3_2() {
        // given
        String testString = "abc";

        // when
        Throwable thrown = catchThrowable(() -> testString.charAt(3));

        // then
        assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
