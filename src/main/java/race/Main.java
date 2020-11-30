package race;

import race.model.Cars;
import race.model.Race;
import race.view.InputView;
import race.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int carNumber = InputView.getCarNumber();
        int runTotalCount = InputView.getRunCount();

        Cars cars = new Cars(carNumber);
        Race race = new Race(cars);
        cars = race.run(runTotalCount);

        ResultView.printRace(runTotalCount, cars);
    }
}
