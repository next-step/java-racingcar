package racingcar;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class StringUtilsTest {

    @Test
    public void 하이픈으로_바꿀수있다() {
        assertThat(StringUtils.convertToHyphen(1)).isEqualTo("-");
        assertThat(StringUtils.convertToHyphen(2)).isEqualTo("--");
        assertThat(StringUtils.convertToHyphen(3)).isEqualTo("---");
        assertThat(StringUtils.convertToHyphen(4)).isEqualTo("----");
        assertThat(StringUtils.convertToHyphen(5)).isEqualTo("-----");
    }
}