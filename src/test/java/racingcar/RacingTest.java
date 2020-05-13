package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.moving.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @DisplayName("생성 실패: 생성할 Car 의 개수가 0보다 작으면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = { -1, -10000 })
    void failureCreateByLessThanZeroValue(final int value) {
        assertThatThrownBy(() -> Racing.of(value, new RandomMovingStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성 실패: Car 의 이동 전략이 null 인 경우 IllegalArgumentException 발생")
    @Test
    void failureCreateByStrategyIsNull() {
        assertThatThrownBy(() -> Racing.of(0, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임에 필요한 Car 를 생성자의 인자로 받아 생성")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 10000 })
    void create(final int value) {
        assertThatCode(() -> Racing.of(value, new RandomMovingStrategy())).doesNotThrowAnyException();
    }

    @DisplayName("게임을 한 번 수행할 때마다 만들어진 Car 는 이동 또는 정지")
    @Test
    void move() {
        assertThat(Racing.of(3, new RandomMovingStrategy()).run()
                .stream()
                .map(Car::getPosition)).contains(Car.DEFAULT_DISTANCE, Car.DEFAULT_DISTANCE + 1);
    }
}
