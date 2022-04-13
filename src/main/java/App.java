import racingcar.InputView;
import racingcar.RacingCar;
import racingcar.ResultView;


public class App {

    public static void main(String[] args) {
        int participantCarNumber = InputView.enterTheNumberOfCars();
        int tryNumber = InputView.enterTheNumberOfTry();

        RacingCar racingCar = new RacingCar();
        ResultView.show(racingCar.start(participantCarNumber, tryNumber));
    }

}
