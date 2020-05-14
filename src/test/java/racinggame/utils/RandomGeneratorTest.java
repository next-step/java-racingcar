package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RandomGeneratorTest {

    @DisplayName("0이상 매개변수 이하의 랜덤값을 반환한다")
    @ValueSource(ints = {10, 5})
    @ParameterizedTest
    void randomGenerate(int limit) {
        assertThat(RandomGenerator.generateUnder(limit)).isBetween(0, limit);
    }

}
