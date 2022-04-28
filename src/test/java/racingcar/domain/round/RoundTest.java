package racingcar.domain.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarPosition;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.car.CarNameTest.VALID_CAR_NAME;
import static racingcar.domain.car.CarPositionTest.DEFAULT_CAR_POSITION;
import static racingcar.domain.car.CarPositionTest.WINNER_CAR_POSITION;

@DisplayName("자동차 경주 - Round 테스트")
class RoundTest {
    private Cars cars;
    private final List<CarPosition> carPositions = List.of(WINNER_CAR_POSITION, DEFAULT_CAR_POSITION, DEFAULT_CAR_POSITION, DEFAULT_CAR_POSITION, WINNER_CAR_POSITION);

    @BeforeEach
    public void init() {
        cars = createMovableCars(carPositions);
    }

    private Cars createMovableCars(List<CarPosition> carPositions) {
        return new Cars(carPositions.stream()
                .map(position -> new Car(VALID_CAR_NAME, position, () -> true))
                .collect(Collectors.toList()));
    }

    @Test
    void play는_cars를_동작시킨다() {
        Round round = new Round(cars);

        assertThat(round.play()
                .getCars()
                .getCars()
                .stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()))
                .isEqualTo(getMovedPositions(carPositions));
    }

    private List<Integer> getMovedPositions(List<CarPosition> carPositions) {
        return carPositions.stream()
                .map(carPosition -> carPosition.increase().getPosition())
                .collect(Collectors.toList());
    }

    @Test
    void Round는_cars_없이_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Round(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
