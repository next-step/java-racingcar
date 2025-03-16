package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("랜덤값이 4미만일 때 자동차는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {3})
    void notMove(int randomNumber) {
        int expected = car.position();
        car.move(randomNumber);
        assertThat(car.position()).isEqualTo(expected);
    }

    @DisplayName("랜덤값이 4이상일 때 자동차는 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4})
    void move(int randomNumber) {
        int expected = car.position() + 1;
        car.move(randomNumber);
        assertThat(car.position()).isEqualTo(expected);
    }
}
