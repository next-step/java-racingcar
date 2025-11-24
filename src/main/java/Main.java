import model.CarRacingGame;
import ui.InputView;
import ui.ResultView;

public class Main {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();
        CarRacingGame carRacingGame = new CarRacingGame(tryCount, carNames);

        ResultView.printResultStart();
        while(!carRacingGame.isFinished()) {
            carRacingGame.race();
            ResultView.printRacingStatus(carRacingGame.getCars());
        }

        ResultView.printWinners(carRacingGame.findWinner());
    }
}
