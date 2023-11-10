package racing;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingApplication {
    public static void main(String[] args){
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        ResultView.printResultMessage();
        race(carCount, tryCount);
    }

    public static void race(int carCount, int tryCount){
        Racing racing = new Racing(carCount);
        for(int i=0; i<tryCount; i++){
            racing.roundStart();
            ResultView.printPositionList(racing.getCarList());
            ResultView.printNewLine();
        }
    }
}
