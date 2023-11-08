package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.util.NumberUtil;

import static org.assertj.core.api.Assertions.*;

public class NumberUtilTest {

    @DisplayName("0~9사이의 임의의 값을 생성한다.")
    @Test
    void stepOnAccelerator() {
        // given & when & then
        for (int i=0; i<10; i++) {
            int number = NumberUtil.createRandomNum();
            assertThat(number).isBetween(0, 9);
        }
    }
}
