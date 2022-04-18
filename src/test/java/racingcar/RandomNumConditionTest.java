package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class RandomNumConditionTest {

    @ParameterizedTest
    @DisplayName("랜덤숫자 4~9 이상인 경우 isSatisfied 메서드 true 반환")
    @CsvSource({"4", "9"})
    void isSatisfiedWhenRandomValueGraterThanFour(int num) {
        RandomNumCondition randomNumCondition = new RandomNumCondition(new RandomGenerator(num, num + 1));
        Assertions.assertThat(randomNumCondition.isSatisfied()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("랜덤숫자 0~3 사이인 경우 isSatisfied 메서드 false 반환")
    @CsvSource({"0", "3"})
    void DisSatisfiedWhenRandomValueUnderFour(int num) {
        RandomNumCondition randomNumCondition = new RandomNumCondition(new RandomGenerator(num, num + 1));
        Assertions.assertThat(randomNumCondition.isSatisfied()).isFalse();
    }

    @Test
    @DisplayName("랜덤숫자 10 초과인 경우 isSatisfied 메서드 false 반환")
    void DisSatisfiedWhenRandomValueGreaterThanTen() {
        RandomNumCondition randomNumCondition = new RandomNumCondition(new RandomGenerator(10, 11));
        Assertions.assertThat(randomNumCondition.isSatisfied()).isFalse();
    }
}