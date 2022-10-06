package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView =  new InputView();
        int cars = inputView.inputCars();
        int raceCnt = inputView.inputRaceCnt();

        CarRace carRace = new CarRace();
        List<Car> racedCars = carRace.race(cars, raceCnt);
        new OutView().printResult(racedCars);
    }
}
