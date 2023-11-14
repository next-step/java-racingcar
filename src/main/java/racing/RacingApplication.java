package racing;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingApplication {
    public static void main(String[] args){
        String[] carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        ResultView.printResultMessage();
        race(carNames, tryCount);
    }

    public static void race(int carCount, int tryCount){
        Racing racing = new Racing(carCount);
        for(int i=0; i<tryCount; i++){
            racing.roundStart();
            ResultView.printPositionList(racing.getCarList());
            ResultView.printNewLine();
        }
    }

    public static void race(String[] carNames, int tryCount){
        Racing racing = new Racing(carNames);
        for(int i=0; i<tryCount; i++){
            racing.roundStart();
            ResultView.printPositionWithNameList(racing.getCarList());
            ResultView.printNewLine();
        }
        ResultView.printWinner(racing.getCarList());
    }
}
