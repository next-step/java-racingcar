package racingcar.backend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차 객체 생성 by names")
    void create_cars_by_names() {
        Cars cars = Cars.create(new String[]{"AA", "BB", "CC"});
        assertThat(cars.getValues()).hasSize(3)
                .extracting(Car::getName).contains(new CarName("AA"), new CarName("BB"), new CarName("CC"));
    }
}
