package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    public void 자동차_갯수_카운트테스트(){
        List<Car> list =carList(0,1,2,3,4);
        Cars cars = new Cars(list);
        assertThat(cars.count()).isEqualTo(list.size());
    }

    @Test
    public void 자동차_생성테스트() {
        List<Car> list = carList(0,1,2,3,4);
        Cars cars = new Cars(list);
        assertThat(cars).isEqualTo(new Cars(list));
        assertThat(cars.count()).isEqualTo(list.size());
    }

    @Test
    public void 자동차_갯수로_생성테스트() {
        Cars cars = Cars.of(1);
        assertThat(cars.count()).isEqualTo(1);
        assertThat(cars).isEqualTo(new Cars(carList(0)));
    }

    @Test
    public void 자동차_이동테스트() {
        List<Car> list = carList(List.of(0,3));
        Cars cars = new Cars(list);
        cars.move(0,4);
        cars.move(1,3);
        assertThat(cars).isEqualTo(new Cars(carList(1,3)));
    }

    private static List<Car> carList(int ...positions){
        return carList(Arrays.stream(positions).boxed().collect(Collectors.toList()));
    }

    private static List<Car> carList(List<Integer> positions) {
        ArrayList<Car> list = new ArrayList<>();
        for(Integer position:positions){
            list.add(new Car(position));
        }
        return list;
    }

}
