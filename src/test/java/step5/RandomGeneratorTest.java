package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RandomGeneratorTest {

    private RandomGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        randomGenerator = new RandomGenerator();
    }

    @Test
    @DisplayName("0~9사이 랜덤값을 생성하는 기능 테스트")
    void generate() {
        assertAll(
                () -> assertThat(randomGenerator.generate()).isGreaterThanOrEqualTo(0),
                () -> assertThat(randomGenerator.generate()).isLessThanOrEqualTo(9)
        );
    }
}
