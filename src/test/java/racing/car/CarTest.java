package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final int NOT_MOVEMENT_VALUE = 0;

    @ValueSource(ints = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    })
    @DisplayName("Move 테스트")
    @ParameterizedTest
    public void moveTest(int distance) {
        Car car = new Car();
        Location beforeLocation = car.getLocation();

        car.move(new Location(distance));

        assertThat(
                car.getLocation()
                        .min(beforeLocation)
                        .getValue()
        ).withFailMessage("지정한 횟수만큼 이동하지 않았습니다.")
                .isEqualTo(distance < 4 ? NOT_MOVEMENT_VALUE : distance);
    }
}