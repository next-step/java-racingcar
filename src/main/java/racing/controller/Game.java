package racing.controller;

import racing.model.Car;
import racing.model.Cars;
import racing.view.GameInput;
import racing.view.GameOutput;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void play() {
        final String[] carArray = GameInput.getCarArrayBySplit();
        final Cars cars = this.carSetting(carArray);
        GameOutput.printCarCount(cars);

        final int roundCount = GameInput.roundCount();
        GameOutput.printRoundCount(roundCount);
        this.playRace(roundCount, cars);
        Cars winner = this.summaryRaceResult(cars);
        GameOutput.printNoticeWinner(winner);
    }

    public Cars carSetting(String[] carArray) {
        List<Car> Cars = new ArrayList<>();
        final int carCount = carArray.length;
        for (int i = 0; i < carCount; i++) {
            String carName = carArray[i];
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
            GameOutput.printDivideRound();
        }
    }

    public Cars summaryRaceResult(Cars cars) {
        final int winnerLocation = cars.getWinnerLocation();
        return cars.getWinner(winnerLocation);
    }
}
