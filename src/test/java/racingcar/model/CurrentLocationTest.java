package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.CurrentLocation;

import static org.assertj.core.api.Assertions.assertThat;

class CurrentLocationTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("움직임의 규칙을 만족하는지 확인한다")
    void meetsMovementRuleTest(int number) {
        CurrentLocation currentLocation = new CurrentLocation();
        assertThat(currentLocation.meetsMovementRule(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("움직임의 규칙을 만족하지 않음을 확인한다")
    void doesNotMeetMovementRuleTest(int number) {
        CurrentLocation currentLocation = new CurrentLocation();
        assertThat(currentLocation.meetsMovementRule(number)).isFalse();
    }

}