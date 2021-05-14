package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

}
