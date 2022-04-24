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
import static racingcar.domain.car.CarNameTest.validCarName;
import static racingcar.domain.car.CarPositionTest.defaultPosition;

@DisplayName("자동차 경주 - Rounds 테스트")
class RoundsTest {
    private static final int ROUND_COUNTS = 4;

    private List<CarPosition> carPositions;
    private Cars movableCars;

    @BeforeEach
    public void init() {
        carPositions = List.of(defaultPosition, defaultPosition, defaultPosition, defaultPosition, defaultPosition);
        movableCars = createMovableCars(carPositions);
    }

    private Cars createMovableCars(List<CarPosition> carPositions) {
        return new Cars(carPositions
                .stream()
                .map(position -> new Car(validCarName, position, () -> true))
                .collect(Collectors.toList()));
    }

    @Test
    void play는_전체_라운드_결과를_반환한다() {
        List<Round> roundResults = new Rounds(movableCars, ROUND_COUNTS).play();

        for (int i = 0; i < ROUND_COUNTS; i++) {
            carPositions = increaseCarPositions(carPositions);

            assertThat(roundResults.get(i)
                    .getCars()
                    .getCars()
                    .stream()
                    .map(Car::getPosition)
                    .collect(Collectors.toList()))
                    .isEqualTo(getPositions(carPositions));
        }
    }

    private List<CarPosition> increaseCarPositions(List<CarPosition> carPositions) {
        return carPositions
                .stream()
                .map(CarPosition::increase)
                .collect(Collectors.toList());
    }

    private List<Integer> getPositions(List<CarPosition> carPositions) {
        return carPositions
                .stream()
                .map(CarPosition::getPosition)
                .collect(Collectors.toList());
    }

    @Test
    void Rounds는_cars_없이_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Rounds(null, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Rounds는_1회_미만으로_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Rounds(movableCars, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
