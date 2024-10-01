package racing.utils;

import com.racing.utils.RacingHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingHelperTest {

    @Test
    @DisplayName("0~9 사이의 랜덤 값을 반환 받는지 여부 확인")
    public void isBetween_RangeOfRandomNumber() {
        int expectedMinNum = 0;
        int expectedMaxNum = 10;

        assertThat(RacingHelper.getRandomNumber()).isGreaterThanOrEqualTo(expectedMinNum)
                .isLessThan(expectedMaxNum);
    }
}
