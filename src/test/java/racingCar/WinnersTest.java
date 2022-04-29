package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WinnersTest {

    @Test
    void 단일우승자(){
        ArrayList<Car> carList = new ArrayList<>();
        Car crong = new Car("crong",4);
        carList.add(crong);
        carList.add(new Car("pobi",3));
        carList.add(new Car("honux",2));

        Cars cars = new Cars(carList);
        List<Car> winners = cars.winnerCars();

        Assertions.assertThat(winners).contains(crong);
    }
    @Test
    void 복수우승자(){
        ArrayList<Car> carList = new ArrayList<>();
        Car crong = new Car("crong",4);
        Car pobi = new Car("pobi",4);
        carList.add(crong);
        carList.add(pobi);
        carList.add(new Car("honux",2));

        Cars cars = new Cars(carList);
        List<Car> winners = cars.winnerCars();

        Assertions.assertThat(winners).contains(crong,pobi);
    }
}
