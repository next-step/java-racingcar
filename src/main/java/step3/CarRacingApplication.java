package step3;

import step3.controller.CarRacingController;
import step3.domain.CarRacingResult;
import step3.util.StringUtil;
import step3.util.ViewUtil;
import step3.view.InputView;
import step3.view.ResultView;

public class CarRacingApplication {

    public static void main(String[] args) {
        String carsName = ViewUtil.inputCarName();
        int roundsCount = ViewUtil.inputRoundCount();

        InputView inputView = new InputView(StringUtil.split(",", carsName), roundsCount);

        CarRacingController carRacingController = new CarRacingController(inputView);

        CarRacingResult carRacingResult = carRacingController.startCarRacing();
        ResultView resultView = new ResultView(carRacingResult);
        resultView.printOutRacingResult();
        resultView.printOutWinnerCarName();
    }

}
