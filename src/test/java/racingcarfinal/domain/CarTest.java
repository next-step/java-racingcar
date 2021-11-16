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
        assertThat(car).isInstanceOf(Car.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    void move(int moveValue, int position) {
        car.move(moveValue);
        assertThat(car.isSamePosition(new Position(position)))
                .isTrue();
    }

}
