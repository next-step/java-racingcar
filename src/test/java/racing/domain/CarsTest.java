package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racing.domain.CarFactory.mustGoMoveConditionSupplier;

class CarsTest {

    List<Car> carList;

    @BeforeEach
    public void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("car1", mustGoMoveConditionSupplier));
        carList.add(new Car("car2", mustGoMoveConditionSupplier));
        carList.add(new Car("car3", mustGoMoveConditionSupplier));
    }

    @Test
    public void givenCars_whenMove_thenAllCarsMove() {
        Cars cars = new Cars(this.carList);
        cars.move();

        for(Car car : cars.getCarList()) {
            assertThat(car.isSamePosition(2)).isTrue();
        }
    }

    @Test
    public void givenCars_whenWinners_thenReturnWinners() {
        Cars cars = new Cars(this.carList);
        Cars winners = cars.winners();
        assertThat(winners.isSize(3)).isTrue();
    }
}