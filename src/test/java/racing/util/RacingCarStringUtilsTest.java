package racing.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarStringUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void null은_허용하지_않는다() {
        RacingCarStringUtils.splitNames(null, ",");
        Assertions.fail("예외가 발생하지 않음");
    }

    @Test
    public void 문자열_잘리는지_확인() {
        List<String> names = RacingCarStringUtils.splitNames("감자,웅,세종", ",");
        assertThat(names).isEqualTo(Arrays.asList("감자", "웅", "세종"));
    }

    @Test
    public void 쉼표사이의_공백_제거_확인() {
        List<String> names = RacingCarStringUtils.splitNames("감자  , 세종", ",");
        assertThat(names).isEqualTo(Arrays.asList("감자", "세종"));
    }

    @Test
    public void hyphen생성유틸_검증() {
        String hyphenStr = RacingCarStringUtils.getHyphenStr(3);

        assertThat(hyphenStr).isEqualTo("---");
    }

    @Test(expected = IllegalArgumentException.class)
    public void hyphen생성시_사이즈는_0보다_커야_함() {
        RacingCarStringUtils.getHyphenStr(-1);
        Assertions.fail("예외가 발생하지 않음");
    }

}