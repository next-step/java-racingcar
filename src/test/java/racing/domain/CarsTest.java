package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void from() {
        Assertions.assertThat(Cars.from("test").getCarList().size())
                .isEqualTo(1);
    }

    @Test
    void getHighPosition() {
        Cars cars = Cars.from("test, 1, 2, 3");
        Assertions.assertThat(cars.getHighPosition())
                .isEqualTo(0);
    }

    @Test
    void validNames() {
        Assertions.assertThatThrownBy(() -> {
            Cars.from("");
        }).isInstanceOf(IllegalArgumentException.class);
    }


}