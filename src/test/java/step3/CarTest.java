package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    public void initCalculator() {
        car = new Car();
    }

    @Test
    @DisplayName("Car Move")
    public void carMove() {
        //given
        int expected = 1;

        //when
        car.move();

        //then
        assertThat(car.now()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} / value = {0}")
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1", "5:1", "6:1"}, delimiter = ':')
    @DisplayName("Car Move If")
    public void carMoveIf(int num, int expected) {
        //given, when
        car.moveIf(num);

        //then
        assertThat(car.now()).isEqualTo(expected);
    }
}
