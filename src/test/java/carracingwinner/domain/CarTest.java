package carracingwinner.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    void moveTest(int moveValue, int position) {
        Car car = new Car("pobi");

        car.move(moveValue);

        assertThat(car.getPosition()).isEqualTo(position);
    }

}
