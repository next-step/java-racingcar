import controller.Controller;
import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = Controller.getCarNames();
        int playCount = Controller.getPlayCount();

        RacingGame racingGame = new RacingGame(carNames, playCount);
        while (!racingGame.isEnd()) {
            racingGame.race();
            Controller.printCars(racingGame.getCars());
        }
        Controller.printWinners(racingGame.getWinners());
    }
}
