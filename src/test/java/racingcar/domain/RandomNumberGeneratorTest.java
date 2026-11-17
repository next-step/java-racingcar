package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("0 ~ 9 의 값을 생성한다")
    void generateRandomNumberInRange() {
        NumberGenerator numberGenerator = new RandomNumberGenerator(10);

        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            result.add(numberGenerator.generate());
        }

        assertThat(result).containsExactlyInAnyOrder(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
