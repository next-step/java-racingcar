package step3.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertUtilTest {

    @Test
    @DisplayName("입력된 자동차 전진 수만큼 -가 출력되어 성공")
    void convertNumToDashSuccess() {
        StringBuilder sb = new StringBuilder();
        sb.append("---");
        assertThat(ConvertUtil.convertNumToDash(3)).isEqualToIgnoringCase(sb);
    }
}
