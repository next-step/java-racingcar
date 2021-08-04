package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringUtilTest {

    @DisplayName("참가자 이름 입력 테스트")
    @Test
    void participantsSplitTest() {
        String participants = "name1,name2,name3";
        assertThat(StringUtil.participantsSplit(participants).length).isEqualTo(3);
    }

    @DisplayName("참가자 이름 입력 예외 테스트")
    @Test
    void participantsSplitExceptionTest() {
        String participants = "";
        assertThatThrownBy(() -> StringUtil.participantsSplit(participants))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자는 1명 이상이어야 합니다.");
    }

}