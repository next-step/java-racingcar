package car.step3;

import car.step3.domain.Car;
import car.step3.domain.Cars;
import car.step3.domain.Position;
import car.step3.service.CarService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    CarService carService = new CarService();
    @Test
    public void 차가_전진하는지_테스트() {
        Car car = new Car("lim");
        car.go(() -> true);
        assertThat(car).isEqualTo(new Car("lim", new Position(1)));
    }

    @Test
    public void 차가_정지하는지_확인하는_테스트() {
        Car car = new Car("kim");

        car.go(() -> false);
        assertThat(car).isEqualTo(new Car("kim", new Position(0)));
    }

    @Test
    public void 가장긴거리() {
        Cars cars = new Cars(Arrays.asList(new Car("young", new Position(3)),
                new Car("lim", new Position(3)),
                new Car("kim", new Position(2))));
        cars.findMaxPosition();
        assertThat(cars.maxPosition).isEqualTo(new Position(3));
    }

    @Test
    public void 이긴_사람을_찾다() {
        Cars cars = new Cars(Arrays.asList(new Car("young", new Position(3)),
                new Car("lim", new Position(3)),
                new Car("kim", new Position(2))));
        List<Car> winners = cars.findWinners();
        assertThat(winners).contains(new Car("young", new Position(3)),
                new Car("lim", new Position(3)));
    }

}