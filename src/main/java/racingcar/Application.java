package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int cars = new InputView().inputCars();
        int raceCnt = new InputView().inputRaceCnt();

        List<Car> joinCars = new CarRace().createCars(cars);
        List<Car> racedCars = new CarRace().startRace(raceCnt, joinCars);

        new OutView().printResult(racedCars);
    }
}
