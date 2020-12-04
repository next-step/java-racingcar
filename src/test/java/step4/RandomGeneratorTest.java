package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class RandomGeneratorTest {

    @Test
    @DisplayName("0~9사이 랜덤값을 생성하는 기능 테스트")
    void generate() {
        assertAll(
                () -> assertThat(RandomGenerator.generate()).isGreaterThanOrEqualTo(0),
                () -> assertThat(RandomGenerator.generate()).isLessThanOrEqualTo(9)
        );
    }
}
