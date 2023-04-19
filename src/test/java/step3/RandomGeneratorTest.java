package step3;

import org.junit.jupiter.api.RepeatedTest;
import step3.util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class RandomGeneratorTest {

    @RepeatedTest(100)
    void 입력한_숫자_미만_0_이상_랜덤정수_생성() {
        assertThat(RandomGenerator.generate(10)).isBetween(0, 9);
    }
}
