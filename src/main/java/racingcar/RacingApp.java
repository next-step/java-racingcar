package racingcar;

import java.util.List;

public class RacingApp {
    public static void main(String[] args) throws Exception {
        String[] carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();
        Race race = new Race();
        race.createCars(carNames);
        ResultView.printResult(race.cars, 1);
        for (int i = 2; i <= tryNumber; i++) {
            race.rollCars();
            ResultView.printResult(race.cars, i);
        }
        List<String> winners = race.findWinners();
        ResultView.printWinners(winners);
    }
}