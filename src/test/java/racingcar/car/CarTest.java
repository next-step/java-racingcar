package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    Car car = new Car();

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("차 forward 에 따라 position 더해지는 것 확인")
    void forwardTest(int add) {
        car.forward(add);
        assertThat(car.getPosition()).isEqualTo(add);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,-", "2,--", "3,---"})
    @DisplayName("Car의 position에 맞춰 - 호출하는 것 테스트")
    void printPositionTest(int add, String expected) {
        car.forward(add);
        assertThat(car.printPosition()).isEqualTo(expected);
    }
}