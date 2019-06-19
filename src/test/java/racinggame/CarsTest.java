package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarsTest {
    private String carNameString = "pobi,crong,honux";
    private int carQuantity = 3;

    @Test
    void 생성자_정상() {
        Cars cars = new Cars(carNameString);
        assertThat(cars.getCars().size()).isEqualTo(carQuantity);
    }

    @Test
    void 생성자_비정상() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Cars(""));
    }
}
