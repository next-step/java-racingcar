package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void two_cars() {
        Cars cars = new Cars(2);
        String mileage1 = cars.forward(1, 1);
        String mileage2 = cars.forward(2, 1);

        assertThat(mileage1).isEqualTo("-");
        assertThat(mileage2).isEqualTo("-");
    }
}
