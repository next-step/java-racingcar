package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    public void 자동차_갯수_카운트테스트(){
        List<Car> list = List.of(new Car(0), new Car(1), new Car(2), new Car(3), new Car(4));
        Cars cars = new Cars(list);
        assertThat(cars.count()).isEqualTo(list.size());
    }

    @Test
    public void 자동차_생성테스트() {
        List<Car> list = List.of(new Car(0), new Car(1), new Car(2), new Car(3), new Car(4));
        Cars cars = new Cars(list);
        assertThat(cars.count()).isEqualTo(1);
        assertThat(cars.getCars()).containsAll(list);
    }

    @Test
    public void 자동차_갯수로_생성테스트() {
        Cars cars = Cars.of(1);
        assertThat(cars.count()).isEqualTo(1);
        assertThat(cars.getCars()).contains(new Car(0));
    }

    @Test
    public void 자동차_이동테스트() {
        List<Car> list = List.of(new Car(0),new Car(3));
        Cars cars = new Cars(list);
        cars.mode(0,4);
        cars.mode(1,3);
        assertThat(cars.getCars()).containsAll(List.of(new Car(1),new Car(3)));
    }

}
