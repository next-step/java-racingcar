package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 8, 9})
    @DisplayName("이동 테스트")
    void runMoveTest(int input) {
        Car car = new Car(input);

        car.run(() -> true);

        assertThat(car.getCurrentPosition()).isEqualTo(input + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("중지 테스트")
    void runStopTest(int input) {
        Car car = new Car(input);

        car.run(() -> false);

        assertThat(car.getCurrentPosition()).isEqualTo(input);
    }

}
