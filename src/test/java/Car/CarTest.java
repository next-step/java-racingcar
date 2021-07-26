package Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void 자동차초기상태테스트() {
        int carMoveCount = car.getMoveCount();
        assertThat(carMoveCount).isEqualTo(0);
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
        int carMoveCount = car.getMoveCount();
        assertThat(carMoveCount).isEqualTo(moveAnswer);
    }

}