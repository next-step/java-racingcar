package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @RepeatedTest(1000)
    public void 올바른_무작위_숫자를_반환하는지_확인() {
        List<Integer> zeroToNineNumbers = new ArrayList<>();
        for (int number = 0; number < 10; number++) {
            zeroToNineNumbers.add(number);
        }
        assertThat(zeroToNineNumbers).contains(RandomNumberGenerator.getRandomNumber());
    }

}