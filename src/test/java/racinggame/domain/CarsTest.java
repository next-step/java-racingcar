package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import racinggame.random.CapacityGenerator;

public class CarsTest {

    @Test
    public void 자동차_생성테스트() {
        List<Car> list = carList(List.of(0, 1, 2, 3, 4), List.of("t1", "t2", "t3", "t4", "t5"));
        Cars cars = new Cars(list);
        assertThat(cars).isEqualTo(new Cars(list));
    }

    @Test
    public void 자동차_이름으로_생성테스트() {
        List<String> names = List.of("t1", "t2");
        Cars cars = Cars.from(names);
        assertThat(cars).isEqualTo(new Cars(carList(List.of(1, 1), names)));
    }

    @Test
    public void 자동차_이동테스트() {
        List<String> names = List.of("t1", "t2");
        List<Car> list = carList(List.of(0, 3), names);
        Cars cars = new Cars(list);
        cars.move(new CapacityGenerator() {

            private List<Integer> result = List.of(4, 3);
            private Iterator<Integer> iter = result.iterator();

            @Override
            public int generate() {
                if (!iter.hasNext()) {
                    this.iter = result.iterator();
                }
                return iter.next();
            }
        });
        assertThat(cars).isEqualTo(new Cars(carList(List.of(1, 3), names)));
    }

    @Test
    public void 우승자_테스트() {
        List<String> names = List.of("t1", "t2");
        List<Car> list = carList(List.of(0, 3), names);
        Cars cars = new Cars(list);
        List<String> winners = cars.winners();
        assertThat(winners).isEqualTo(List.of("t2"));
    }

    private static List<Car> carList(List<Integer> positions, List<String> names) {
        ArrayList<Car> list = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            list.add(new Car(positions.get(i), names.get(i)));
        }
        return list;
    }

}
