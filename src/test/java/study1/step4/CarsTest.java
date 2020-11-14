package study1.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("Cars 생성 테스트  ")
    void createCars(){
        String first_race = "first";
        String second_race = "second";
        String third_race = "third";

        String[] racerList = {first_race, second_race, third_race};

        Cars cars = new Cars();

        cars.initializeCars(racerList);

        List<Car> carsSample = new ArrayList<>();
        for(String racer: racerList){
            carsSample.add(new Car(racer, 1));
        }

        assertThat(cars.getCars()).isEqualTo(carsSample);
    }

    @Test
    @DisplayName("라운드 진행 테스트")
    void raceTest(){
        String[] racerList = {"first", "second", "third"};

        Cars cars = new Cars();

        cars.initializeCars(racerList);

        Decision moveGenerator = new FixedMoveDecision(10);

        cars.race(moveGenerator);
        cars.race(moveGenerator);
        cars.race(moveGenerator);

        for(Car car: cars.getCars()){
            assertThat(car.isBestRacer(4)).isEqualTo(true);
        }
        Decision notMoveGenerator = new FixedMoveDecision(1);

        cars.race(notMoveGenerator);
        cars.race(notMoveGenerator);
        cars.race(notMoveGenerator);

        for(Car car: cars.getCars()){
            assertThat(car.isBestRacer(4)).isEqualTo(true);
        }

    }
}
