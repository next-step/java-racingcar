package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private SimpleCar car;

    @BeforeEach
    void init() {
        car = new SimpleCar("test");
    }

    @Test
    @DisplayName("최초 포지션은 0")
    void Test_initial_position_0() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {":false", "carname_too_long:false", "abc:true"}, delimiter = ':')
    @DisplayName("이름 부여 5글자 제한")
    void Test_car_name_length_validation(String inputName, boolean expected) {
        // when
        boolean isValid = SimpleCar.isValidName(inputName);

        // then
        assertThat(isValid).isEqualTo(expected);
    }

    @Test
    void Test_create_car_with_name() {
        // given
        String carName = "abc";

        // when
        SimpleCar testCar = new SimpleCar(carName);

        // then
        assertThat(testCar.getCarName()).isEqualTo(carName);
    }

    @Test
    void Given_car_When_copy_Then_name_position_same() {
        // given
        SimpleCar car = new SimpleCar("abcd");
        car.run();

        // when
        SimpleCar copiedCar = car.copy();

        // then
        assertThat(copiedCar.getCarName()).isEqualTo(car.getCarName());
        assertThat(copiedCar.getPosition()).isEqualTo(car.getPosition());
    }
}
