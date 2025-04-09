package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    @DisplayName("라운드 수만큼 자동차가 항상 움직이는지 테스트")
    public void testRacingRounds() {
        int numOfRounds = 5;

        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("가", () -> true);
        Car car2 = new Car("나", () -> true);
        Car car3 = new Car("다", () -> true);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = new Cars(carList);

        for (int i = 0; i < numOfRounds; i++) {
            cars.moveAllCars();
        }

        List<Integer> positions = cars.getPositions();
        for (Integer position : positions) {
            assertThat(position).isEqualTo(numOfRounds);
        }
    }

    @Test
    public void single_winning_car() {
        int numOfRounds = 5;

        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("가", () -> true);
        Car car2 = new Car("나", () -> false);
        Car car3 = new Car("다", () -> false);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = new Cars(carList);

        for (int i = 0; i < numOfRounds; i++) {
            cars.moveAllCars();
        }

        List<Car> winningCars = cars.findWinningCar();
        assertThat(winningCars).hasSize(1);
        assertThat(winningCars.get(0)).isEqualTo(car1);
    }
}
