package racing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameManagementTest {
    @Test
    @DisplayName("이동상태 GO 를 추가한다")
    void duplicatedCarTest() {
        RacingCars racingCars = generateCars(new String[]{"CarA", "CarB"});
        RacingGameManagement racingGameManagement = initRacingGameManagement(racingCars);
        racingGameManagement.addDrivingStatus(racingCars.findCarByCarName("CarA"), CarDrivingType.GO);

        CarDrivingTypes carDrivingTypes = racingGameManagement.findDrivingTypes(racingCars.findCarByCarName("CarA"));

        assertThat(carDrivingTypes.getCarDrivingType(0)).isEqualTo(CarDrivingType.GO);
    }

    @Test
    @DisplayName("우승차 리스트를 가져온다")
    void winnerCarsTest() {
        RacingCars racingCars = generateCars(new String[]{"CarA", "CarB", "CarC"});
        RacingGameManagement racingGameManagement = initRacingGameManagement(racingCars);
        racingGameManagement.addDrivingStatus(racingCars.findCarByCarName("CarA"), CarDrivingType.GO);
        racingGameManagement.addDrivingStatus(racingCars.findCarByCarName("CarA"), CarDrivingType.GO);
        racingGameManagement.addDrivingStatus(racingCars.findCarByCarName("CarC"), CarDrivingType.GO);
        racingGameManagement.addDrivingStatus(racingCars.findCarByCarName("CarC"), CarDrivingType.GO);

        WinnerRacingCars winners = racingGameManagement.findWinners();

        assertThat(winners.getCars()).contains("CarA", "CarC");
    }

    private static RacingCars generateCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(generateCar(carName));
        }
        return new RacingCars(cars);
    }

    private static Car generateCar(String carNames) {
        return new Car(carNames);
    }

    private static RacingGameManagement initRacingGameManagement(RacingCars racingCars) {
        Map<Car, CarDrivingTypes> racingGameManagement = new HashMap<>();

        for (Car car : racingCars) {
            racingGameManagement.put(car, new CarDrivingTypes(new ArrayList<CarDrivingType>()));
        }
        return new RacingGameManagement(racingGameManagement);
    }
}
