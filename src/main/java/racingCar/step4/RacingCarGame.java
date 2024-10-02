package racingCar.step4;

import racingCar.step3.ResultView;

public class RacingCarGame {
    public void gameStart(){
        String carNames = InputView.getCarNamesInputFromUser();
        int racingCount = InputView.getRacingCountInputFromUser();

        ResultView.printResultMessage();
    }
}
