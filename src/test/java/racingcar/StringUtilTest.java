package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.StringUtil.splitBySeparator;

public class StringUtilTest {

    @Test
    public void testSplitByComma(){
        assertThat(splitBySeparator(",", "a, b, c")).containsExactly("a", "b", "c");
        assertThat(splitBySeparator(",", "a,b,c")).containsExactly("a", "b", "c");
        assertThat(splitBySeparator(",", "a, b, c ")).containsExactly("a", "b", "c");
        assertThat(splitBySeparator(",", "a,b,c ")).containsExactly("a", "b", "c");
        assertThat(splitBySeparator(",", "")).contains("");
        assertThat(splitBySeparator(",", " a,b  ,c ")).containsExactly("a", "b", "c");


    }

}
