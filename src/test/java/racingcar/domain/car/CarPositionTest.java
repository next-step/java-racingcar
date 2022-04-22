package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 경주 - CarPosition 테스트")
class CarPositionTest {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVABLE_DISTANCE = 1;

    private final CarPosition defaultPosition = CarPosition.createDefault();

    @Test
    void increase는_position을_증가시킨다() {
        assertThat(defaultPosition.increase()).isEqualTo(new CarPosition(DEFAULT_POSITION + MOVABLE_DISTANCE));
    }

    @Test
    void CarPosition은_0_미만으로_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new CarPosition(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
