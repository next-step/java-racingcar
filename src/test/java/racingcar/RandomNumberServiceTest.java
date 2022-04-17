package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.service.RandomNumberService;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberServiceTest {

    @Test
    void 랜덤값_범위검증() {
        assertThat(RandomNumberService.getRandomNumber()).isGreaterThanOrEqualTo(0);
        assertThat(RandomNumberService.getRandomNumber()).isLessThanOrEqualTo(9);
    }
}
