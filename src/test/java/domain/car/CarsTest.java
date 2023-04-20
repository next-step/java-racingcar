package domain.car;

import domain.car.Car;
import domain.car.Cars;
import domain.car.MoveStrategy;
import domain.game.CarDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @DisplayName("게임 우승자 결과를 반환할 수 있다")
    @Test
    public void winner() {
        Car car1 = new Car("TEST1", () -> true);
        Car car2 = new Car("TEST2", () -> false);
        Car car3 = new Car("TEST3", () -> false);

        Cars cars = new Cars(List.of(car1, car2, car3));
        cars.move();
        List<Car> winners = cars.findWinners();

        assertThat(winners.get(0)).isEqualTo(car1);
    }

    @DisplayName("게임 우승자 여러명인 경우 결과를 반환할 수 있다")
    @Test
    public void winners() {
        Car car1 = new Car("TEST1", () -> true);
        Car car2 = new Car("TEST2", () -> true);
        Car car3 = new Car("TEST3", () -> false);

        Cars cars = new Cars(List.of(car1, car2, car3));
        cars.move();
        List<Car> winners = cars.findWinners();

        assertThat(winners).containsExactly(car1, car2);
    }

    @DisplayName("한 스테이지당 이동결과를 반환할 수 있다")
    @Test
    public void stageResult() {
        MoveStrategy strategy = () -> true;
        Car car1 = new Car("TEST1", strategy);
        Car car2 = new Car("TEST2", strategy);

        Cars cars = new Cars(List.of(car1, car2));
        cars.move();

        List<CarDto> currentResult = cars.getCurrentResult();

        currentResult.forEach(carDto -> assertThat(carDto.getPosition()).isEqualTo(car1.getPosition().intValue()));
    }
}
