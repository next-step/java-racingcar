package racingCar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    private Car car;

    @DisplayName("자동차 이름이 5글자를 넘을 때 에러 발생")
    @Test
    void createCar() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("hihihi"));
    }

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 이동() {
        assertThat(car.move(() -> true)).isEqualTo(new Position(1));
    }

    @Test
    void 정지() {
        assertThat(car.move(() -> false)).isEqualTo(new Position());
    }

    @AfterEach
    void init() {
        car = null;
    }
}