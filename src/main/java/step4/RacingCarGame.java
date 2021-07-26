package step4;

import java.util.ArrayList;

public class RacingCarGame {

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        Referee referee = new Referee(tryCount);
        CarStadium carstadium = new CarStadium(referee, new ArrayList<>());

        for (int i = 0; i < carCount; i++) {
            carstadium.enterCar(new Car(new CarEngine()));
        }

        ResultView resultView = new ResultView();

        for (int i = 0; i < tryCount; i++) {
            carstadium.moveCars();
            resultView.printResult(carstadium);
        }
    }
}
