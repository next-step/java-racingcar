import study.InputView;
import study.RacingManager;
import study.ResultView;

public class RacingCarMain {

    public static void main(String[] args) {
        RacingManager racingManager = new RacingManager();

        int numberOfCar = InputView.enterNumberOfCar();
        racingManager.makeRacingCar(numberOfCar);
        int numberOfAttempt = InputView.enterNumberOfAttempt();

        System.err.println("실행 결과");
        for (int i = 0; i < numberOfAttempt; i++) {
            racingManager.startRacing();
            ResultView.racingResult(racingManager.getCarList());
        }

    }
}
