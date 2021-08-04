package racingcar;

import racingcar.car.Cars;
import racingcar.race.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        Race race = new Race(new Cars(InputView.inputNameOfCars()));
        int racingTime = Integer.parseInt(InputView.inputCountOfGame());
        Cars cars = race.getCars();

        ResultView.printResultTitle();
        for (int i = 0; i < racingTime; i++) {
            race.startRace();
            ResultView.printEachRacing(cars);
        }
        ResultView.printWinnerCars(cars.getRaceWinners());
    }
}
