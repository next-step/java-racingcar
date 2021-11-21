package step4.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.dto.count.Count;

class RandomStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,10,12})
    @DisplayName("4 이상의 값을 인자로 받을 시 참을 반환한다")
    public void trueTest(int input) {
        RandomStrategy randomStrategy = new RandomStrategy();

        Assertions.assertThat(randomStrategy.runnable(new Count(input))).isTrue();
    }
}
