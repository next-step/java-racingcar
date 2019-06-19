package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private String carNameString = "pobi,crong,honux";
    private int carQuantity = 3;

    @Test
    void 생성자_정상() {
        CarNames carNames = new CarNames(carNameString);

        Cars cars = new Cars(carNames);
        assertThat(cars.getCars().size()).isEqualTo(carQuantity);
    }
}
