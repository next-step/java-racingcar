package humbledude.carracing.domain;

import humbledude.carracing.domain.Car;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"name", "1", "한글다섯자"})
    public void carName(String name) {
        assertThat(new Car(name)).isInstanceOf(Car.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "name_1", "long_car_name", "한글여섯글자"})
    public void carName_throwingException(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name));
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "3, 0", "4, 1", "9, 1"})
    public void forward(int fuel, int position){
        Car car = new Car();


        assertThat(car.getPosition()).isEqualTo(0);
        car.accelerate(fuel);
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
