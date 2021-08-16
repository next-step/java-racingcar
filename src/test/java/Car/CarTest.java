package Car;

import Car.domain.Car;
import Car.domain.MoveCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {

        car = new Car("test");
    }

    @Test
    void 자동차초기상태테스트() {
        int actual = car.getMoveCount();
        assertThat(actual).isEqualTo(new MoveCount().getMoveCount());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "3, 0",
            "4, 1",
            "5, 1",
            "8, 1"
    })
    void 자동차움직임테스트(int inputNumber, int moveAnswer) {
        car.move(inputNumber);
        int actual = car.getMoveCount();
        assertThat(actual).isEqualTo(new MoveCount(moveAnswer).getMoveCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void 자동차이름테스트(String carName) {
        Car car = new Car(carName);
        assertThat(car.getCarName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"goodCar", "goodCa"})
    void 자동차이름테스트_예외발생(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자를 초과할 수 없습니다.");
    }
}