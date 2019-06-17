package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {


    @ParameterizedTest
    @CsvSource(value = {
            "5,1",
            "4,1",
            "8,1",
            "7,1"
    })
    @DisplayName("4이상의 출력으로 움직였을때")
    public void move(int input, int expected) {

        MockEngine engine = new MockEngine(input);
        Car car = new Car(engine);
        assertThat(car.getMovement()).isEqualTo(0);
        car.move();
        assertThat(car.getMovement()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,0",
            "0,0",
            "3,0",
            "2,0"
    })
    @DisplayName("4보다 작은 출력으로 움직였을때")
    public void engineOutputBelessthan4(int input, int expected) {

        MockEngine engine = new MockEngine(input);
        Car car = new Car(engine);
        assertThat(car.getMovement()).isEqualTo(0);
        car.move();
        assertThat(car.getMovement()).isEqualTo(expected);
    }
}