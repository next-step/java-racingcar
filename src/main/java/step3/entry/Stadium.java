package step3.entry;

import step3.logic.Race;
import step3.ui.InputView;
import step3.ui.OutputView;

public class Stadium {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Race race = new Race(inputView.readNumberCars());

        for (int it = inputView.readNumberIterations(); it > 0; --it) {
            race.lap();
            outputView.showStatus(race.getCars());
            System.out.println();
        }
    }
}
