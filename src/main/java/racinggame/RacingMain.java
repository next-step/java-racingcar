package racinggame;

import racinggame.domain.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        try {
            String carNames = InputView.getCarNames();
            int tryNo = InputView.getTryNo();

            RacingGame racingGame = new RacingGame(carNames, tryNo);
            while(racingGame.racing()) {
                racingGame.race();
                ResultView.printCars(racingGame.getCars());
            }
            ResultView.printWinners(racingGame.getWinners());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
