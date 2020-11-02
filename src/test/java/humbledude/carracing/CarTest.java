package humbledude.carracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "3, 0", "4, 1", "9, 1"})
    public void forward(int fuel, int position){
        Car car = new Car();


        assertThat(car.getPosition()).isEqualTo(0);
        car.accelerate(fuel);
        assertThat(car.getPosition()).isEqualTo(position);
    }




}
