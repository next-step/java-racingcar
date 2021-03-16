package step3;

import java.util.List;

public class CarRacingApplication {

    public static void main(String[] args) {
        String carsName = ViewUtil.inputCarName();
        int roundsCount = ViewUtil.inputRoundCount();

        InputView inputView = new InputView(StringUtil.split(",", carsName), roundsCount);

        CarRacingController carRacingController = new CarRacingController(inputView);

        List<CarResultDto> carResultDtoList = carRacingController.startCarRacing();
        ResultView resultView = new ResultView(carResultDtoList);
        resultView.printOutRacingResult();
        resultView.printOutWinnerCarName();
    }

}
