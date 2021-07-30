package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarUtilsTest {

    @Test
    void random_number_test() {

        int numberForMovement = CarUtils.getNumberForMovement();

        assertThat(numberForMovement).isGreaterThan(-1);
        assertThat(numberForMovement).isLessThan(10);

    }
}