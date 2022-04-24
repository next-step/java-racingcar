package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.car.CarTest.MOVABLE_DISTANCE;

@DisplayName("자동차 경주 - CarPosition 테스트")
public class CarPositionTest {
    private static final int DEFAULT_POSITION = 0;
    private static final int INVALID_POSITION = -1;
    private static final int WINNER_POSITION = 10;

    static final CarPosition winnerPosition = new CarPosition(WINNER_POSITION);
    public static final CarPosition defaultPosition = CarPosition.createDefault();

    @Test
    void CarPosition은_지정된_position으로_생성이_가능하다() {
        assertThat(new CarPosition(DEFAULT_POSITION))
                .isInstanceOf(CarPosition.class);
    }

    @Test
    void CarPosition은_기본위치_생성이_가능하다() {
        assertThat(CarPosition.createDefault())
                .isInstanceOf(CarPosition.class);
    }

    @Test
    void increase는_position을_증가시킨다() {
        assertThat(defaultPosition.increase())
                .isEqualTo(new CarPosition(DEFAULT_POSITION + MOVABLE_DISTANCE));
    }

    @Test
    void CarPosition은_0_미만으로_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new CarPosition(INVALID_POSITION);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
