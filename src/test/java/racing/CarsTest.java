package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Cars createCars(int count) {
        List<String> names = IntStream.range(0, count)
                .mapToObj(i -> String.format("car%d", i))
                .collect(Collectors.toList());
        return new Cars(names);
    }

    @DisplayName("자동차들은 이동후 Position 증가한다")
    @Test
    void carMoveForward() {
        Cars cars = createCars(3);
        cars.run(() -> true);
        assertThat(cars.getCars()).allMatch(car -> car.getPosition().getCurrentPosition() == 1);
    }

    @DisplayName("특정 위치에 해당하는 자동차를 반환하는지 테스트")
    @Test
    void getCarsEqualsPositionTest() {
        Cars cars = createCars(1);
        cars.run(() -> true);
        cars.getCars().forEach(car -> System.out.println("car.getPosition().getCurrentPosition() = " + car.getPosition().getCurrentPosition()));
        assertThat(cars.getCarsEqualsPosition(new Position(1))).hasSize(1);
    }

    @DisplayName("제일 많이 전진한 자동차의 위치 가져오기 테스트")
    @Test
    void getMaxPositionTest() {
        Cars cars = createCars(5);
        run(cars.getCars(), 2);
        assertThat(cars.getMaxPosition().getCurrentPosition()).isEqualTo(2);
    }

    private void run(List<Car> cars, int count) {
        Car car = cars.get(cars.size() - 1);
        for (int i = 0; i < count; i++) {
            car.run(() -> true);
        }
    }
}