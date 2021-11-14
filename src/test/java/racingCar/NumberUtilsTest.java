package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.utils.NumberUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberUtilsTest {
    @Test
    void 랜덤_숫자_생성_테스트() {
        assertThat(NumberUtils.getRandomNumber()).isBetween(0, 9);
    }
}
