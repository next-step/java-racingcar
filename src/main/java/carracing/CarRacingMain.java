package carracing;

import carracing.model.Cars;
import carracing.service.CarRacingService;
import carracing.util.ExceptionUtils;
import carracing.view.InputView;
import carracing.view.ResultView;

public class CarRacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Integer carCount = inputView.inputCarCount();
        Integer tryCount = inputView.inputTryCount();

        CarRacingService carRacingService = new CarRacingService(new Cars(carCount), tryCount);
        Cars cars = carRacingService.gameStart();

        try {
            ResultView resultView = new ResultView(cars);
            resultView.outputGameResults();
        } catch (InterruptedException e) {
            System.out.println(ExceptionUtils.INTERRUPTED_EXCEPTION);
        }
    }

}
