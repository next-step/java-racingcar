package racingCar;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import racingcar.RaceUtil;
import racingcar.RandomUtil;

import java.util.stream.IntStream;

public class RacingCarTest {
    
    @Test
    void 랜덤값생성을요청했을때_성공() {
        // when
        int randomVal = RandomUtil.generate();

        // then
        assertThat(randomVal).isLessThanOrEqualTo(9);
        assertThat(randomVal).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 자동차가멈추는범위의수가생성되면_정지성공() {
        // when & then
        IntStream.rangeClosed(0, 3).forEach(i -> {
            assertThat(RaceUtil.determineCarMovement(i)).isFalse();
        });

    }

    @Test
    void 자동차가전진하는범위의수가생성되면_전진성공() {
        // when & then
        IntStream.rangeClosed(4, 9).forEach(i -> {
            assertThat(RaceUtil.determineCarMovement(i)).isTrue();
        });
    }
}
