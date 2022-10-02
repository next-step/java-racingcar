package racing.controller;

import racing.model.Car;
import racing.model.Cars;
import racing.view.GameInput;
import racing.view.GameOutput;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    public void play() {
        final List<String> carNames = GameInput.getCarArrayBySplit();
        final Cars cars = this.carSetting(carNames);
        GameOutput.printCarCount(cars);

        final int roundCount = GameInput.roundCount();
        GameOutput.printRoundCount(roundCount);
        this.playRace(roundCount, cars);
        Cars winner = this.summaryRaceResult(cars);
        GameOutput.printNoticeWinner(winner);
    }

    public Cars carSetting(List<String> carNames) {
        return new Cars(
                carNames.stream()
                        .map(it -> new Car(0, it))
                        .collect(Collectors.toList())
        );
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
