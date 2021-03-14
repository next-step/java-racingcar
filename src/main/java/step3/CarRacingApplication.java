package step3;

import java.util.List;

public class CarRacingApplication {

    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            inputView.inputCarsName();
            inputView.inputRoundsCount();

            CarRacingController carRacingController = new CarRacingController(new Round(inputView.getRoundsCount()),
                    new CarRacing(inputView.getCarsName()));

            List<CarResultDto> carResultDtoList = carRacingController.startCarRacing();
            ResultView resultView = new ResultView(carResultDtoList);
            resultView.printOutRacingResult();
            resultView.printOutWinnerCarName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
