package study.racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("truly");

    }

    @ParameterizedTest
    @CsvSource(value = {"2, 0", "3, 0", "4, 1", "5, 1"})
    void move_test(int randomNo, int result) throws Exception {

        car.move(randomNo);

        int position = car.getPosition();

        assertThat(result).isEqualTo(position);
    }

    @Test
    void advanced_test() throws Exception {

        int bfPos = car.getPosition();
        car.advanced();

        int position = car.getPosition();

        assertThat(bfPos + 1).isEqualTo(position);
    }

    @Test
    void name_test() throws Exception {
        String inputName = "truly";
        Car car = new Car(inputName);
        String carName = car.getName();

        assertThat(inputName).isEqualTo(carName);
    }

    @Test
    void name_exception_test() throws Exception {
        String inputName = "sparkle";
        assertThatThrownBy(() -> {
            Car car = new Car(inputName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
