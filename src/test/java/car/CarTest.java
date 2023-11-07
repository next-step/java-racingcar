package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("전진 테스트")
    void 전진(int number) {
        Car car = new Car();
        int initPosition = car.currentPosition();

        car.move(number);

        assertThat(car.currentPosition()).isEqualTo(initPosition + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("정지 테스트")
    void 정지(int number) {
        Car car = new Car();
        int initPosition = car.currentPosition();

        car.move(number);

        assertThat(car.currentPosition()).isEqualTo(initPosition);
    }

}
