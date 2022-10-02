package racing.controller;

import racing.model.Car;
import racing.model.Cars;
import racing.view.GameInput;
import racing.view.GameOutput;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void play() {
        final List<String> carNameList = GameInput.getCarArrayBySplit();
        final Cars cars = this.carSetting(carNameList);
        GameOutput.printCarCount(cars);

        final int roundCount = GameInput.roundCount();
        GameOutput.printRoundCount(roundCount);
        this.playRace(roundCount, cars);
        Cars winner = this.summaryRaceResult(cars);
        GameOutput.printNoticeWinner(winner);
    }

    public Cars carSetting(List<String> carNameList) {
        List<Car> Cars = new ArrayList<>();
        for (String carName : carNameList) {
            Car car = new Car(0, carName);
            Cars.add(car);
        }
        Cars cars = new Cars(Cars);
        return cars;
    }

    public void playRace(int roundCount, Cars cars) {
        GameOutput.printStartRace();
        for (int i = 0; i < roundCount; i++) {
            cars.playRound();
            GameOutput.printRoundResultCurrentLocationAndCarName(cars.getCarList());
        }
    }

    public Cars summaryRaceResult(Cars cars) {
        return cars.getWinner();
    }
}
