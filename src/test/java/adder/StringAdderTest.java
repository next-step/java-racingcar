package adder;

import org.junit.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class StringAdderTest {

    @Test
    public void 덧셈_공백() {
        assertThat(StringAdder.add(""))
            .isEqualTo(0);
    }

    @Test
    public void 덧셈_숫자한개() {
        assertThat(StringAdder.add("1"))
            .isEqualTo(1);
    }

    @Test
    public void 덧셈_컴마구분자_숫자두개() {
        assertThat(StringAdder.add("1,2"))
            .isEqualTo(3);
    }

    @Test
    public void 덧셈_컴마구분자_숫자세개() {
        assertThat(StringAdder.add("1,2,3"))
            .isEqualTo(6);
    }

    @Test
    public void 덧셈_쉼표구분자_숫자두개() {
        assertThat(StringAdder.add("1:2"))
                .isEqualTo(3);
    }

    @Test
    public void 덧셈_쉼표구분자_숫자세개() {
        assertThat(StringAdder.add("1:2:3"))
                .isEqualTo(6);
    }

    @Test
    public void 구분자_정규식() {
        final String regex = "//(.)\n";
        assertThat("//;\n".matches(regex))
                .isTrue();

        assertThat("//;1".matches(regex))
                .isFalse();
    }

    @Test
    public void 구분자_추출_정규식() {
        final String regex = "//(.)\n(.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("//;\n123");
        if (matcher.find()) {
            assertThat(matcher.group(1)).isEqualTo(";");
            assertThat(matcher.group(2)).isEqualTo("123");
        } else {
            fail();
        }
    }

    @Test
    public void 덧셈_커스텀구분자_숫자두개() {
        assertThat(StringAdder.add("//;\n1;2"))
                .isEqualTo(3);
    }

    @Test
    public void 덧셈_커스텀구분자_숫자세개() {
        assertThat(StringAdder.add("//;\n1;2;3"))
                .isEqualTo(6);
    }

    @Test
    public void 빈문자열() {
        assertThat(StringAdder.add(null))
                .isEqualTo(0);
        assertThat(StringAdder.add(""))
                .isEqualTo(0);
    }

    @Test
    public void 공백포함() {
        assertThat(StringAdder.add(" 1, 2, 3 "))
                .isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수() {
        StringAdder.add("-1, 1");
    }

    @Test(expected = NumberFormatException.class)
    public void 숫자의외의값() {
        StringAdder.add("1, a");
    }
}
