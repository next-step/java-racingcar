package race;

import race.race.CarRace;
import race.race.TryCount;
import race.view.InputView;
import race.view.ResultView;

public class Main {

    public static void main(String[] args) {
        CarRace carRace = new CarRace(InputView.inputCarName(), new TryCount(InputView.inputTryCount()));

        ResultView.output(carRace.getCars());
        while (carRace.isPlus()) {
            carRace.proceedRound();
            ResultView.output(carRace.getCars());
        }

        ResultView.announceWinner(carRace.getRaceResult());
    }
}
