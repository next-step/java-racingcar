package step3;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class RandomGeneratorTest {

    @RepeatedTest(100)
    void 범위가_주어지면_랜덤정수_반환() {
        assertThat(RandomGenerator.generate(-3, 3)).isBetween(-3, 3);
    }

    @Test
    void min가_max보다_큰경우_예외() {
        assertThatThrownBy(()-> RandomGenerator.generate(3, -3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void min와_max가_같은경우_예외() {
        assertThatThrownBy(()-> RandomGenerator.generate(5, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
