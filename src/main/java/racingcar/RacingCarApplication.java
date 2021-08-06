package racingcar;

import racingcar.domain.car.Cars;
import racingcar.domain.race.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        Race race = new Race(new Cars(InputView.inputNameOfCars()), InputView.inputCountOfGame());
        int racingTime = race.getRacingTime();
        Cars cars = race.getCars();

        ResultView.printResultTitle();
        for (int i = 0; i < racingTime; i++) {
            race.startRace();
            ResultView.printEachRacing(cars);
        }
        ResultView.printWinnerCars(race.getRaceWinners());
    }
}
