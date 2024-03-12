package racingCar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤값은 0 ~ 9 사이 정수")
    void stop_the_car() {
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        assertThat(result.contains(randomGenerator.generate())).isEqualTo(true);
    }
}
