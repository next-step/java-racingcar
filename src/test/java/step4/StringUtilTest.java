package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.util.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @DisplayName("콤마가 포함된 문자열을 분리한다.")
    @Test
    void commaTest() {
        String str = "test1,test2,test3";
        assertThat(StringUtil.deviceComma(str))
                .containsExactly("test1", "test2", "test3");
    }
}
