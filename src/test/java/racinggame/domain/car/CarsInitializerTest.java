package racinggame.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racinggame.domain.car.CarsInitializer.DELIMITER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.car.Cars;
import racinggame.domain.car.CarsInitializer;
import racinggame.domain.exception.InvalidCarNameException;
import racinggame.domain.exception.InvalidCarRegistrationException;

class CarsInitializerTest {

    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux")
    @DisplayName("주어진 명단대로 차를 생성하기")
    void init_cars(String carNames) {
        Cars cars = CarsInitializer.initCars(carNames);

        assertAll(
                () -> assertThat(cars.getSize()).isEqualTo(carNames.split(DELIMITER).length),
                () -> assertThat(cars.getCar(0).getName()).isEqualTo("pobi"),
                () -> assertThat(cars.getCar(1).getName()).isEqualTo("crong"),
                () -> assertThat(cars.getCar(2).getName()).isEqualTo("honux")
        );

    }

    @ParameterizedTest
    @NullSource
    @DisplayName("차량을 아예 등록하지 않으면 예외 발생.")
    void fail_to_register_no_car(String carNames) {
        assertThatThrownBy(() -> CarsInitializer.initCars(carNames))
                .isInstanceOf(InvalidCarRegistrationException.class);

    }
    @ParameterizedTest
    @EmptySource
    @DisplayName("빈 이름을 등록하면 예외 발생.")
    void fail_to_register_empty_name_car(String carNames) {
        assertThatThrownBy(() -> CarsInitializer.initCars(carNames))
                .isInstanceOf(InvalidCarNameException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,looooooongname")
    @DisplayName("차 이름이 5자 초과이면 예외 발생.")
    void fail_to_register_long_name_car(String carNames) {
        assertThatThrownBy(() -> CarsInitializer.initCars(carNames))
                .isInstanceOf(InvalidCarNameException.class);

    }

}