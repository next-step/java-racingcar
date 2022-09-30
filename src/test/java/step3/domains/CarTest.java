package step3.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,false",
            "3,false",
            "4,true",
            "9,true"
    })
    void Given_Integer_GreaterThanFour_When_Move_Then_MoveForward(int number, boolean expected) {
        Car car = Car.init("car");

        Car moveCar = car.move(number);

        assertThat(car.getPosition() != moveCar.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abcde"})
    void Given_Name_LessThanEquals_5_When_InitCar_Then_Created(String name) {
        assertThatNoException().isThrownBy(() -> Car.init(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void Given_BlankName_When_InitCar_Then_Created(String name) {
        assertThatThrownBy(() -> Car.init(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
