package racingcar.backend.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    String[] carNames;

    @BeforeEach
    void setUp() {
        carNames = new String[]{"AA", "BB", "CC"};
    }

    @Test
    @DisplayName("자동차 객체 생성 by names")
    void create_Cars_by_names() {
        Cars cars = Cars.create(carNames);
        assertThat(cars.getValues()).hasSize(3)
                .extracting(Car::getName).contains("AA", "BB", "CC");
    }
}
