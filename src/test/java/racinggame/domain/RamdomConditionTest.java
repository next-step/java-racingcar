package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RamdomConditionTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 9})
    @DisplayName("random 값이 4이상일 경우 조건 만족하는지 확인한다")
    void meet(int number) {
        RamdomCondition meetRandomCondition = new RamdomCondition(new RandomValue(number));
        assertThat(meetRandomCondition.meet()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("random 값이 4 미만일 경우 조건을 만족하지 않는지 확인한다")
    void unMeet(int number) {
        RamdomCondition unmeetRandomCondition = new RamdomCondition(new RandomValue(number));
        assertThat(unmeetRandomCondition.meet()).isFalse();
    }
}
