package racingcar;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public static List<Car> initialCars(int carCount) {
        List<Car> carList = new ArrayList<>();

        for (int x = 0; x < carCount; x++) {
            carList.add(new Car());
        }
        return carList;
    }

    public static void startRaceByStep(List<Car> cars){
        for (Car car : cars) {
            RacingCarService.runByCar(car);
        }
    }

    public static int runByCar(Car car) {
        if (SpeedUtils.possibleMoveSpeedByRandomSpeed()){
            car.move();
        }
        return car.getPosition();
    }

}
