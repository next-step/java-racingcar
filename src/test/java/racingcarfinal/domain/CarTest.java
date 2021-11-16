package racingcarfinal.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final String name = "pobi";
    private final Car car = new Car(name);

    @Test
    void create() {
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,1", "4,1"})
    void move(int moveValue, int position) {
        car.move(moveValue);
        assertThat(car.getPosition()).isEqualTo(position);
    }

}
