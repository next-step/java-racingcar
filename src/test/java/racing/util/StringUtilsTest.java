package racing.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void null은_허용하지_않는다() {
        StringUtils.splitByComma(null);
        Assertions.fail("예외가 발생하지 않음");
    }

    @Test
    public void 문자열_잘리는지_확인() {
        List<String> names = StringUtils.splitByComma("감자,웅,세종");
        Assertions.assertThat(names).isEqualTo(Arrays.asList("감자", "웅", "세종"));
    }

    @Test
    public void 쉼표사이의_공백_제거_확인() {
        List<String> names = StringUtils.splitByComma("감자  , 세종");
        Assertions.assertThat(names).isEqualTo(Arrays.asList("감자", "세종"));
    }

}