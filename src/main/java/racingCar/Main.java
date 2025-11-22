package racingCar;

import racingCar.domain.CarRace;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class Main {
    public static void main(String[] args) {
        String[] names = InputView.inputCarName();
        int roundCount = InputView.inputRunCount();

        CarRace carRace = new CarRace(names, roundCount);

        while(carRace.hasNextRound()) {
            carRace.play();
            ResultView.show(carRace.getCars());
        }

        ResultView.showWinner(carRace.getWinners());
    }
}
