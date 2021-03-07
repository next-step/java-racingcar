import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @Test
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void generateCars(int numberOfCars, int result) {
        assertThat(new CarFactory(numberOfCars)
                .generateCars()
                .size())
                .isEqualTo(result);
    }
}