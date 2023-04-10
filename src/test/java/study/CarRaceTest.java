package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {

    private static final int INITIAL_CAR_NUMBER = 10;
    private static final String INITIAL_CAR_NAMES = "car1,car2,car3,car4,car5,car6,car7,car8,car9,car10";
    private List<Car> initialCars = new ArrayList<>();
    private static final int FINAL_CAR_NUMBER = 5;
    private List<Car> finalCars = new ArrayList<>();

    @BeforeEach
    void settingCars() {
        initialCars = InputView.readCars(INITIAL_CAR_NAMES);
        finalCars.add(new Car(1, "car1"));
        finalCars.add(new Car(3, "car2"));
        finalCars.add(new Car(5, "car3"));
        finalCars.add(new Car(5, "car4"));
        finalCars.add(new Car(2, "car5"));

    }


    @Test
    void 전진_테스트() {
        List<Car> cars = CarRace.readyCars(INITIAL_CAR_NUMBER);
        List<Car> movedCars = CarRace.moveCars(cars);

        assertThat(movedCars).hasSize(INITIAL_CAR_NUMBER);
        for (int i = 0; i < movedCars.size(); i++) {
            Car before = cars.get(i);
            Car after = movedCars.get(i);
            assertThat(after.getCurrentLocation()).isGreaterThanOrEqualTo(before.getCurrentLocation());

            if (after.getCurrentLocation() > before.getCurrentLocation()) {
                assertThat(after.getCurrentLocation()).isEqualTo(before.getCurrentLocation() + 1);
            }
        }
    }

    @Test
    void 전진_가능_로직_테스트() {
        Car before = new Car(1);

        Car after = CarRace.moveOrStop(before);

        assertThat(after.getCurrentLocation()).isGreaterThanOrEqualTo(before.getCurrentLocation());

        if (after.getCurrentLocation() > before.getCurrentLocation()) {
            assertThat(after.getCurrentLocation()).isEqualTo(before.getCurrentLocation() + 1);
        }
    }

    @Test
    void 가장_멀리_이동한_거리() {
        int longestDistance = CarRace.getLongestDistance(finalCars);
        assertThat(longestDistance).isEqualTo(5);
    }

    @Test
    void 특정_위치의_자동차를_리스트에_추가() {
        List<Car> carsWithLocation = new ArrayList<>();
        CarRace.getCarsWithLocation(5, carsWithLocation, new Car(5, "car"));
        assertThat(carsWithLocation).hasSize(1);
        assertThat(carsWithLocation.get(0).getName()).isEqualTo("car");
    }

    @Test
    void 특정_위치의_자동차가_아니라면_리스트에_추가_X() {
        List<Car> carsWithLocation = new ArrayList<>();
        CarRace.getCarsWithLocation(5, carsWithLocation, new Car(3, "car"));
        assertThat(carsWithLocation).isEmpty();
    }

    @Test
    void 최종_우승한_자동차() {
        List<Car> winningCars = CarRace.getWinningCars(finalCars);
        assertThat(winningCars).hasSize(2);
    }
}
