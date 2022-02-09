package racingcar.model;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 입력받은_이름으로_Car객체_리스트를_만든다() {
        Cars cars = new Cars(Arrays.asList("pobi", "woni", "jun"));
        List<Car> movedCars = cars.moveCars();
        assertThat(movedCars.get(0).getCarName()).isEqualTo("pobi");
        assertThat(movedCars.get(1).getCarName()).isEqualTo("woni");
        assertThat(movedCars.get(2).getCarName()).isEqualTo("jun");
    }

    @Test
    void 생성된_Car들이_전진한다() {
        Cars cars = new Cars(Arrays.asList("pobi", "woni", "jun"));
        List<Car> movedCars = cars.moveCars();
        assertThat(movedCars.get(0).getPosition()).isNotNull();
    }

    @Test
    void 전진_불가_테스트() {
        MoveStrategy moveStrategy = new NeverMoveStrategy();
        Cars cars = new Cars(Arrays.asList("pobi", "woni", "jun"), moveStrategy);
        List<Car> movedCars = cars.moveCars();
        assertThat(movedCars.get(0).getPosition()).isEqualTo(0);
        assertThat(movedCars.get(1).getPosition()).isEqualTo(0);
        assertThat(movedCars.get(2).getPosition()).isEqualTo(0);
    }

    @Test
    void 전진_가능_테스트() {
        MoveStrategy moveStrategy = new AlwaysMoveStrategy();
        Cars cars = new Cars(Arrays.asList("pobi", "woni", "jun"), moveStrategy);
        List<Car> movedCars = cars.moveCars();
        assertThat(movedCars.get(0).getPosition()).isEqualTo(1);
        assertThat(movedCars.get(1).getPosition()).isEqualTo(1);
        assertThat(movedCars.get(2).getPosition()).isEqualTo(1);
    }

}
