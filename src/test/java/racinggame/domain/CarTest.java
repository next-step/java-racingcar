package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.Car;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4,1","3,0"})
    public void 자동차_전진테스트(int capacity,int position) {
        Car car = new Car(0);
        car.move(capacity);
        assertThat(car).isEqualTo(new Car(position));
    }

}
