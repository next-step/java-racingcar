package racing_winner.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CommonUtilsTest {

    @Test
    @DisplayName("입력값이 정상적으로 나눠지는지 테스트")
    void splitInput() {
        String[] splitInput =CommonUtils.splitInput("pobi,crong,honux");
        assertThat(splitInput).contains("pobi","crong","honux");
    }
}