package racing;

import racing.model.RacingModel;
import racing.view.InputView;


public class RacingApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        RacingModel racingModel = new RacingModel();
        inputView.inputData(racingModel);
        Racing racing = new Racing();
        racing.gameStart(racingModel);
    }

}
