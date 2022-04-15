package racingcar;

import java.util.List;

public class RacingApp {
    public static void main(String[] args) throws Exception {
        String[] carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();
        Race race = new Race();
        race.createCars(carNames);
        for (int i = 1; i <= tryNumber; i++) {
            ResultView.printResult(race.cars, i);
            race.rollCars();
        }
        List<String> winners = race.findWinners();
        ResultView.printWinners(winners);
    }
}