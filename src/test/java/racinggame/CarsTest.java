package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    public void 자동차_생성테스트() {
        List<Car> list = List.of(new Car(0), new Car(1), new Car(2), new Car(3), new Car(4));
        Cars cars = new Cars(list);
        assertThat(cars.getCars()).hasSize(5);
        assertThat(cars.getCars()).containsAll(list);
    }

    @Test
    public void 자동차_갯수로_생성테스트() {
        Cars cars = Cars.of(1);
        assertThat(cars.getCars()).hasSize(1);
        assertThat(cars.getCars()).contains(new Car(0));
    }

    @Test
    public void 자동차_이동테스트() {
        Cars cars = Cars.of(1);
        cars.moveAll();
        assertThat(cars.getCars()).contains(new Car(1));
    }

}
