package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.strategy.RandomStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class RandomStrategyTest {

    @DisplayName("랜덤전략 테스트")
    @RepeatedTest(100)
    public void test() {
        RandomStrategy randomStrategy = new RandomStrategy();
        assertAll(
                () ->
                        assertThat(randomStrategy.generate()).isLessThan(10),
                () ->
                        assertThat(randomStrategy.generate()).isGreaterThanOrEqualTo(0)
        );
    }



}
