package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static racingcar.domain.car.CarPosition.DEFAULT_POSITION;
import static racingcar.domain.car.CarPosition.MOVABLE_DISTANCE;

@DisplayName("자동차 경주 - CarPosition 테스트")
public class CarPositionTest {
    private static final int INVALID_POSITION = -1;
    private static final int WINNER_POSITION = 10;

    public static final CarPosition WINNER_CAR_POSITION = new CarPosition(WINNER_POSITION);
    public static final CarPosition DEFAULT_CAR_POSITION = CarPosition.createDefault();

    @Test
    void CarPosition은_기본위치_생성이_가능하다() {
        CarPosition carPosition = CarPosition.createDefault();

        assertAll(
                () -> assertEquals(DEFAULT_POSITION, carPosition.getPosition()),
                () -> assertInstanceOf(CarPosition.class, carPosition)
        );
    }

    @Test
    void increase는_position을_증가시킨다() {
        assertThat(DEFAULT_CAR_POSITION.increase())
                .isEqualTo(new CarPosition(DEFAULT_POSITION + MOVABLE_DISTANCE));
    }

    @Test
    void CarPosition은_0_미만으로_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new CarPosition(INVALID_POSITION);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
