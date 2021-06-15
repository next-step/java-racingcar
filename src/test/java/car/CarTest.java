package car;

import car.domain.Car;
import car.domain.Copy;
import car.domain.Drive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("java", 5);
    }

    @Test
    void getKm() {
        int actual = 5;
        int expected = car.getKm();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getName() {
        String actual = "java";
        String expected = car.getName();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,5", "3,5", "4,6", "5,6"})
    void changeKm(String input, String expected) {
        car.changeKm(Integer.valueOf(input));

        int km = car.getKm();

        assertThat(Integer.valueOf(expected)).isEqualTo(km);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,5", "4,6"})
    void moveOrStopCar(String value1, String value2) {
        int randomNumber = Integer.valueOf(value1);
        int km = Integer.valueOf(value2);

        car.moveOrStopCar(() -> randomNumber);

        assertThat(car.getKm()).isEqualTo(km);
    }

}
