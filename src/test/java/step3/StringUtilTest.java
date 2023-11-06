package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step3.util.StringUtil.splited;

public class StringUtilTest {

    private static final String TEXT = "pobi,crong,honux";
    private static final String[] SPLITED = {"pobi", "crong", "honux"};

    @Test
    @DisplayName("쉼표를 기준으로 문자열을 분리한다")
    public void 문자열_쉼표_분리() {
        assertThat(splited(TEXT)).isEqualTo(SPLITED);
    }

}
