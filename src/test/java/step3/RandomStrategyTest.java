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

    @DisplayName("자동차 이 테스트 - 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "-2",
            "10"
    })
    public void test2(int value) {
        Car car = new Car();
        assertThatThrownBy(() -> {
                    car.move(value);

                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
