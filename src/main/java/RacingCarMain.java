import study.InputView;
import study.RacingManager;
import study.ResultView;

public class RacingCarMain {

    public static void main(String[] args) {

        int numberOfCar = InputView.enterNumberOfCar();
        RacingManager racingManager = new RacingManager(numberOfCar);
        int numberOfAttempt = InputView.enterNumberOfAttempt();
        System.err.println("실행 결과");
        for (int i = 0; i < numberOfAttempt; i++) {
            racingManager.startRacing();
            ResultView.racingResult(racingManager.getCarList());
        }

    }
}
