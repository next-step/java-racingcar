package race;

import race.model.Race;
import race.view.InputView;

public class Main {
    public static void main(String[] args) {
        int carCount = InputView.getCarNumber();
        int runCount = InputView.getRunCount();

        Race race = new Race(carCount, runCount);
    }
}
