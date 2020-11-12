package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    void from() {
        Assertions.assertThat(Cars.from("test").getCarList().size())
                .isEqualTo(5);
    }

    @Test
    void getVictoryCarNames() {
        Cars cars = Cars.from("test, 1, 2, 3");
        Assertions.assertThat(cars.getVictoryCarNames())
                .isEqualTo("test, 1, 2, 3");
    }

    @Test
    void validNames() {
        Assertions.assertThatThrownBy(() -> {
            Cars.from("");
        }).isInstanceOf(IllegalArgumentException.class);
    }


}