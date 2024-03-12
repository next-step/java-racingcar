package race.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 요청한자동차댓수만큼만_자동차가_만들어진다() {
        // given
        int numberOfCar = 5;
        Cars cars = Cars.createInstance(numberOfCar);

        // when && then
        int expected = 5;
        assertThat(cars.getSize()).isEqualTo(expected);
    }
}