package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    Cars cars;

    @BeforeEach
    void before() {
        cars = new Cars();
    }

    @Test
    void addCar() {
        cars.addCar(new Car(), new Car());

        assertThat(cars.size()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:-","2:--","3:---","4:----","5:-----"}, delimiter = ':')
    void dashOfCarPositions(int input, String dash) {
        // given
        Car car = new Car();
        for (int i = 0; i < input; i++) {
            car.forward();
        }
        cars.addCar(car);
        // when
        List<String> dashOfCarPositions = cars.dashOfCarPositions();
        // then
        assertThat(dashOfCarPositions).first().isEqualTo(dash);
    }


}