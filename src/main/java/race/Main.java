package race;

import race.model.Race;
import race.view.InputView;
import race.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int carNumber = InputView.getCarNumber();
        int runCount = InputView.getRunCount();

        Race race = new Race(carNumber);
        race.run(runCount, new Race.RaceInterface() {
            @Override
            public void getPosition(int position) {
                ResultView.printCarPosition(position);
            }

            @Override
            public void finishTurn() {
                ResultView.markFinishTurn();
            }
        });
    }
}
