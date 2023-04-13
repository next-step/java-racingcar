package race;

import race.view.InputView;
import race.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int numOfCars = InputView.getCarNums();
        int laps = InputView.getLaps();
        PowerGenerator powerGenerator = new RandomPowerGenerator();
        Cars cars = new Cars(numOfCars, powerGenerator);
        Race race = new Race(laps, cars);

        RaceResult result = race.start();
        ResultView resultView = new ResultView(result);
        resultView.showResult();
    }
}
