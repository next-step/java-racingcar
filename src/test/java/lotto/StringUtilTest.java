package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    public void 널인경우(){
        assertThat(StringUtil.isEmpty(null)).isTrue();
    }

    @Test
    public void 공백인경우(){
        assertThat(StringUtil.isEmpty("  ")).isTrue();
        assertThat(StringUtil.isEmpty("")).isTrue();
    }

}
