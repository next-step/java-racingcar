import domain.CarsSnapShots;
import domain.RacingManager;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        final String carString = InputView.inputCarString();
        final int tryNum = InputView.inputTryNum();

        final RacingManager racingManager = new RacingManager(carString, tryNum);

        racingManager.play();

        ResultView.printTitle();
        final CarsSnapShots carsSnapShots = racingManager.getCarsSnapShots();
        ResultView.printResult(carsSnapShots);
        ResultView.printWinners(racingManager.getWinners());
    }
}
