package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import racingcar.utils.StringUtil;

public class StringUtilTest {

    @Test
    public void testSplitByComma(){
        assertThat(StringUtil.splitBySeparator(",", "a, b, c")).containsExactly("a", "b", "c");
        assertThat(StringUtil.splitBySeparator(",", "a,b,c")).containsExactly("a", "b", "c");
        assertThat(StringUtil.splitBySeparator(",", "a, b, c ")).containsExactly("a", "b", "c");
        assertThat(StringUtil.splitBySeparator(",", "a,b,c ")).containsExactly("a", "b", "c");
        assertThat(StringUtil.splitBySeparator(",", "")).contains("");
        assertThat(StringUtil.splitBySeparator(",", " a,b  ,c ")).containsExactly("a", "b", "c");

    }

    @Test
    public void testRepeatString(){
        assertThat(StringUtil.repeat("-", 5)).isEqualTo("-----");
        assertThat(StringUtil.repeat("", 5)).isEmpty();
    }

}
