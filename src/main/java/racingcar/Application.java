package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView =  new InputView();
        int cars = inputView.inputCars();
        int raceCnt = inputView.inputRaceCnt();

        CarRace carRace = new CarRace();
        List<Car> joinCars = carRace.createCars(cars);
        List<Car> racedCars = carRace.startRace(raceCnt, joinCars);
        new OutView().printResult(racedCars);
    }
}
