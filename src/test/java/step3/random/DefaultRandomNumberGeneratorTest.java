package step3.random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultRandomNumberGeneratorTest {

    @DisplayName("범위 0~10까지 난수를 얻을 수 있다")
    @RepeatedTest(100)
    void gerRandomNumber() {
        // given
        DefaultRandomNumberGenerator defaultRandomNumberGenerator = new DefaultRandomNumberGenerator();

        // when
        int result = defaultRandomNumberGenerator.generate();

        // then
        assertThat(result).isNotNegative().isLessThanOrEqualTo(10);
    }


}