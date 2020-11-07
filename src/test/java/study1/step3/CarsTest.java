package study1.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("Cars Test")
    void carsTest(){
        int testNumber = 4;

        Cars cars = Cars.of(testNumber);
        assertThat(cars.getCars().size()).isEqualTo(testNumber);
    }
}
