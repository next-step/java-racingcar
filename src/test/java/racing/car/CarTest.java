package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.car.DistanceRange.*;

class CarTest {

    @ValueSource(ints = {
            1, 2, 3, 4, 5, 6, 7, 8, 9
    })
    @DisplayName("Move 테스트")
    @ParameterizedTest
    public void moveTest(int distanceValue) {
        Car car = new Car();
        Location beforeLocation = car.getLocation();
        Distance distance = Distance.newInstance(distanceValue);

        car.move(distance);

        assertThat(
                car.getLocation()
                        .min(beforeLocation)
                        .getValue()
        ).withFailMessage("지정한 횟수만큼 이동하지 않았습니다.")
                .isEqualTo(
                        distance.getDistanceRange() == NOT_MOVEMENT ?
                                DistanceRange.NOT_MOVEMENT_VALUE :
                                distanceValue
                );
    }
}