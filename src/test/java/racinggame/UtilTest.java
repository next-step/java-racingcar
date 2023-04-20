package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.Util.splitCarName;

public class UtilTest {
    @DisplayName("입력받은 문자열을 , 로 분리")
    @Test
    void test1() {
        assertThat(splitCarName("pobi,crong,honux")).containsExactly("pobi", "crong", "honux");
    }

}
