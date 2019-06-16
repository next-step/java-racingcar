package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.model.RandomCarMover.MOVING_CONDITION;
import static racingcar.model.RandomCarMover.RANDOM_LIMIT;

class MockCarMoverTest {

    @Test
    @DisplayName(MOVING_CONDITION + "이상 인 경우 자동차는 움직인다")
    void moveCar() {
        MockCarMover mover = mockMover(1, 4, 5);
        assertThat(mover.move(new Car())).isFalse();
        assertThat(mover.move(new Car())).isTrue();
        assertThat(mover.move(new Car())).isTrue();
    }

    @DisplayName("임의의 값이 음수 또는 " + RANDOM_LIMIT + "이상이면 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void mockCarMoverWhenWrongState(int wrongState) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> mockMover(wrongState));
    }

    private MockCarMover mockMover(int... randomNumber) {
        List<Integer> collect = Arrays.stream(randomNumber).boxed().collect(Collectors.toList());
        return new MockCarMover(collect);
    }

}