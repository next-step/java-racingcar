package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @DisplayName("지정 범위에서 값이 잘 생성되는지 테스트")
    @Test
    public void 랜덤값은_0부터_9까지_생성된다() {
        NumberGenerator numberGenerator = new ProductRandomGenerator();
        assertThat(numberGenerator.createRandomValue())
                .isLessThan(10);
    }
}