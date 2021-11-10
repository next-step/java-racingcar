package carracing;

import carracing.model.Cars;
import carracing.model.ui.InputDto;
import carracing.service.CarRacingService;
import carracing.view.InputView;
import carracing.view.ResultView;

public class CarRacingMain {

    public static final String INTERRUPTED_EXCEPTION = "진행 중이던 쓰레드가 중단되었습니다.";

    public static void main(String[] args) {
        InputDto inputDto = InputView.getNewCars();

        CarRacingService carRacingService = new CarRacingService(inputDto);
        Cars cars = carRacingService.gameStart();

        try {
            ResultView resultView = new ResultView(cars);
            resultView.outputGameResults();
        } catch (InterruptedException e) {
            System.out.println(INTERRUPTED_EXCEPTION);
        }
    }

}
