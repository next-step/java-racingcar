package step4.racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.racingCar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private Car car;
    private int initialPosition;

    @BeforeEach
    void setUp() {
        car = new Car("jin");
        initialPosition = car.getPosition();
    }

    @ParameterizedTest
    @DisplayName("정지 테스트")
    @ValueSource(ints = {1, 2, 3})
    void stop_car(int input) {
        car.move(input);
        assertThat(car.getPosition()).isSameAs(initialPosition);
    }

    @ParameterizedTest
    @DisplayName("전진 테스트")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_car(int input) {
        //when
        car.move(input);

        //then
        assertThat(car.getPosition()).isSameAs(initialPosition + 1);
    }

    @Test
    @DisplayName("자동차 이름 초과")
    void validateName() {
        assertThatThrownBy(() -> new Car("yeojinyu")).isInstanceOf(RuntimeException.class);
    }
}
