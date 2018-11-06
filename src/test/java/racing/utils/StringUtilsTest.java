package racing.utils;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class StringUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void 문자열이_NULL인_경우_IllegalArgument_예외가_발생되는지_검사() {
        StringUtils.split(null, ",");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구분자가_NULL인_경우_IllegalArgument_예외가_발생되는지_검사() {
        StringUtils.split("홍길동,홍길순,홍길남", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구분자가_공백인_경우_IllegalArgument_예외가_발생되는지_검사() {
        StringUtils.split("홍길동,홍길순,홍길남", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 문자열과_구분자가_NULL인_경우_IllegalArgument_예외가_발생되는지_검사() {
        StringUtils.split("홍길동,홍길순,홍길남", null);
    }

    @Test
    public void 문자열에_들어있지_않은_구분자로_문자열을_자르는_경우_넘긴_문자가_문자열_배열로_그대로_반환되는지_검사() {
        final String[] results = StringUtils.split("홍길동,홍길순,홍길남", "hNWYyLTg5NmQ4MzAwOT");
        assertThat(results).isEqualTo(new String[]{"홍길동,홍길순,홍길남"});
    }

    @Test
    public void 문자열이_공백인_경우_빈_문자열_배열이_반환되는지_검사() {
        final String[] results = StringUtils.split("", ",");
        assertThat(results).isEqualTo(new String[]{""});
    }

    @Test
    public void 콤마를_구분자로_해서_나눈다() {
        final String[] results = StringUtils.split("홍길동,홍길순,홍길남", ",");
        assertThat(results).isEqualTo(new String[]{"홍길동", "홍길순", "홍길남"});
    }

}