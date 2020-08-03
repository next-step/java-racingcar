package camp.nextstep.edu.rebellion.racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {
    @DisplayName("null 케이스일 경우 empty 확인")
    @Test
    public void nullTest() {
        // given
        String str = null;

        // when
        boolean expected = StringUtil.isEmpty(str);

        // then
        assertThat(expected).isTrue();
    }

    @DisplayName("공백 케이스일 경우 empty 확인")
    @Test
    public void emptySpaceTest() {
        // given
        String str = "";

        // when
        boolean expected = StringUtil.isEmpty(str);

        // then
        assertThat(expected).isTrue();
    }
}
