package racingcar.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {


    @Test
    public void 랜덤값을_구해봅시다아_from_0_to_9() {
        int randomNumber = RandomNumberGenerator.getRandomNumberZeroToNine();
        assertThat(randomNumber).isBetween(0,9);
    }
}