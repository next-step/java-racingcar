package study.racing4;

import study.racing4.domain.CarRacing;
import study.racing4.domain.RandomMovingStrategy;
import study.racing4.view.InputView;
import study.racing4.view.ResultView;

public class CarRacingApp {

    public static void main(String... args) {

        InputView inputView = new InputView();

        CarRacing racing = new CarRacing(inputView.getRacingInput(), new RandomMovingStrategy());

        ResultView resultView = new ResultView();

        resultView.printCarPosition(racing.getCars());
        while(racing.isProcessAbleRound()) {
            racing.processRound();
            resultView.printCarPosition(racing.getCars());
        }

        resultView.printWinner(racing.getWinnerCar());
    }

}
