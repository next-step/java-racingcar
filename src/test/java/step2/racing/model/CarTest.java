package step2.racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.racing.model.Car.DEFAULT_POSITION;
import static step2.racing.model.Car.MOVE_VALUE;

class CarTest {

    private Car car = Car.of(1);

    @ParameterizedTest(name = "랜덤값 : {arguments}")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤값이 4 미만이라면 이동하지 않고, 9 이상이라면 이동한다")
    void race_should_move(int randomNumber) {

        car.race(randomNumber);

        if (randomNumber >= MOVE_VALUE) {
            assertThat(car.getPosition()).isGreaterThan(DEFAULT_POSITION);
        } else {
            assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION);
        }
    }
}