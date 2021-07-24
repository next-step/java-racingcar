package racing;

import racing.model.RacingModel;
import racing.view.InputView;
import racing.view.RacingView;


public class RacingApplication {

    public static void main(String[] args) {

        RacingModel racingModel = new RacingModel();
        InputView inputView = new InputView();
        inputView.inputData(racingModel);
        racing(racingModel);
    }

    static void racing(RacingModel racingModel) {
        RacingView racingView = new RacingView();
        RacingCar racingCar = new RacingCar();
        int count = 0;
        while (count < racingModel.getCount()) {
            racingCar.move(racingModel);
            racingView.printCarMove(racingModel);
            count++;
        }
    }
}
