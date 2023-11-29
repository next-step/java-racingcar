package racingCar.controller;

import racingCar.domain.Race;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class RacingGameController {
    public static void main(String[] args) {
        Race race = new Race(InputView.carNames());
        Integer numberOfRace = InputView.numberOfRace();

        ResultView.executionResultSign();
        for (int i = 0; i < numberOfRace; i++) {
            race.singleRace();
            ResultView.showDistance(race.cars());
            ResultView.showNextRound();
        }
        ResultView.announceWinner(race.winners());
    }
}
