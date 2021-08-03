import study.racingcar.domain.RacingManager;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class RacingCarMain {

    public static void main(String[] args) {

        String nameOfCar = InputView.enterNameOfCars();
        RacingManager racingManager = new RacingManager(nameOfCar);
        int numberOfAttempt = InputView.enterNumberOfAttempt();
        System.err.println("실행 결과");
        for (int i = 0; i < numberOfAttempt; i++) {
            racingManager.startRacing();
            ResultView.racingResult(racingManager.getCarList());
        }
        ResultView.racingWinnerResult(racingManager.getRacingWinners());
    }
}
