package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarListsTest {
    private int carQuantity = 3;

    @Test
    void 생성자_정상() {
        CarLists carLists = new CarLists(carQuantity);
        Assertions.assertThat(carLists.getCarList().size()).isEqualTo(carQuantity);
    }

    @Test
    void 생성자_비정상() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarLists(CarLists.MIN_CAR_QUANTITY - 1));
    }
}
