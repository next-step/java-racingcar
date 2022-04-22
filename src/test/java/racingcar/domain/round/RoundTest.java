package racingcar.domain.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarPosition;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.car.CarNameTest.VALID_CAR_NAME;

@DisplayName("자동차 경주 - Round 테스트")
class RoundTest {
    private static final int WINNER_POSITION = 5;
    private final CarPosition winnerPosition = new CarPosition(WINNER_POSITION);
    private final CarPosition defaultPosition = CarPosition.createDefault();

    private Cars cars;
    private final List<CarPosition> carPositions = List.of(winnerPosition, defaultPosition, defaultPosition, defaultPosition, winnerPosition);

    @BeforeEach
    public void init() {
        cars = createMovableCars(carPositions);
    }

    private Cars createMovableCars(List<CarPosition> carPositions) {
        return new Cars(carPositions.stream()
                .map(position -> new Car(new CarName(VALID_CAR_NAME), position, () -> true))
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
                .isEqualTo(carPositions.stream()
                        .map(CarPosition::increase)
                        .collect(Collectors.toList()));
    }

    @Test
    void Round는_cars_없이_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Round(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
