package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.random.Radom;

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
        assertThat(cars).isEqualTo(new Cars(carList(1)));
    }

    @Test
    public void 자동차_이동테스트() {
        List<Car> list = carList(List.of(0,3));
        Cars cars = new Cars(list);
        cars.move(new Radom() {

            private List<Integer> result=List.of(4,3);
            private Iterator<Integer> iter=result.iterator();

            @Override
            public int generate() {
                if(!iter.hasNext()){
                    this.iter=result.iterator();
                }
                return iter.next();
            }
        });
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
