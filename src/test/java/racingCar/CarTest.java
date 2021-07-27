package racingCar;

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
    void canMove() {
        assertThat(car.canMove(4)).isTrue();
        assertThat(car.canMove(3)).isFalse();
    }

    @Test
    void 이동() {
        assertThat(car.move(5)).isEqualTo(1);
        assertThat(car.move(4)).isEqualTo(2);
        assertThat(car.move(3)).isEqualTo(2);
    }

    @AfterEach
    void init() {
        car = null;
    }
}