package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RandomNumConditionTest {

    @Test
    @DisplayName("랜덤숫자 4 이상인 경우 isSatisfied 메서드 true 반환")
    void isSatisfiedWhenRandomValueGraterThanFour() {
        RandomNumCondition randomNumCondition = new RandomNumCondition(new RandomGenerator(4, 9));
        Assertions.assertThat(randomNumCondition.isSatisfied()).isTrue();
    }

    @Test
    @DisplayName("랜덤숫자 4 미만인 경우 isSatisfied 메서드 false 반환")
    void DisSatisfiedWhenRandomValueUnderFour() {
        RandomNumCondition randomNumCondition = new RandomNumCondition(new RandomGenerator(1, 3));
        Assertions.assertThat(randomNumCondition.isSatisfied()).isFalse();
    }
}