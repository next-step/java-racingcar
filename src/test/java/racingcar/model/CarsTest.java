package racingcar.model;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 입력받은_이름으로_Car객체_리스트를_만든다() {
        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean moveOrNot() {
                if (new Random().nextInt(10) > 4) {
                    return true;
                }
                return false;
            }

        };
        Cars cars = new Cars(Arrays.asList(
            new Car("jiin"), new Car("leah"), new Car("sam")));
        List<Car> movedCars = cars.moveCars(moveStrategy);
        assertThat(movedCars.get(0).getCarName()).isEqualTo("jiin");
        assertThat(movedCars.get(1).getCarName()).isEqualTo("leah");
        assertThat(movedCars.get(2).getCarName()).isEqualTo("sam");
    }

    @Test
    void 생성된_Car들이_전진한다() {
        MoveStrategy moveStrategy = new RandomStrategy();
        Cars cars = new Cars(Arrays.asList(new Car("jiin"), new Car("leah"), new Car("sam")));
        List<Car> movedCars = cars.moveCars(() -> true);
        assertThat(movedCars.get(0).getPosition()).isNotNull();
    }

    @Test
    void 전진_불가_테스트() {
        Cars cars = new Cars(Arrays.asList(new Car("jiin"), new Car("leah"), new Car("sam")));
        List<Car> movedCars = cars.moveCars(new MoveStrategy() {
            @Override
            public boolean moveOrNot() {
                return false;
            }
        });
        assertThat(movedCars.get(0).getPosition()).isEqualTo(0);
        assertThat(movedCars.get(1).getPosition()).isEqualTo(0);
        assertThat(movedCars.get(2).getPosition()).isEqualTo(0);
    }

    @Test
    void 전진_가능_테스트() {
        Cars cars = new Cars(Arrays.asList(new Car("jiin"), new Car("leah"), new Car("sam")));
        List<Car> movedCars = cars.moveCars(() -> true);
        assertThat(movedCars.get(0).getPosition()).isEqualTo(1);
        assertThat(movedCars.get(1).getPosition()).isEqualTo(1);
        assertThat(movedCars.get(2).getPosition()).isEqualTo(1);
    }

}
