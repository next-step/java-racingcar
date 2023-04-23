package car.step3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    HandleCar handleCar = new HandleCar();
    @Test
    public void 차가_전진하는지_테스트() {
        Car car = new Car("lim");

        car.go(new MovingStrategy() {
            @Override
            public boolean movable() {
                return true;
            }
        });
        assertThat(car.location()).isEqualTo(1);
    }

    @Test
    public void 차가_정지하는지_확인하는_테스트() {
        Car car = new Car("kim");

        car.go(() -> false);
        assertThat(car.location()).isEqualTo(0);
    }

    @Test
    public void 차리스트를_조회하여_전진한다() {
        List<Car> carList = Arrays.asList(new Car("jiyoung"), new Car("celineååååå"));
        List<Car> newCarList = handleCar.iteratorCar(carList);
        assertThat(newCarList.size()).isEqualTo(carList.size());
        assertThat(newCarList.get(0).location()).isGreaterThanOrEqualTo(carList.get(0).location());
    }

    @Test
    public void 이긴_사람을_찾다() {
        Winner winner = new Winner();
        List<Car> cars = Arrays.asList(new Car("jiyoung", 3),
                new Car("lim", 3),
                new Car("kim", 2));
        List<String> winners = winner.findWinner(cars);
        assertThat(winners).contains("jiyoung", "lim");
    }

}