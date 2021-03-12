package step3;

public class CarRacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputCarsCount();
        inputView.inputRoundsCount();

        CarRacing carRacing = new CarRacing(inputView.getCarsCount());
        Round round = new Round(inputView.getRoundsCount());

        ResultView resultView = new ResultView();
        while (round.isRoundContinue()) {
            carRacing.moveForward();
            resultView.addCarRacingResult(new CarResultDto(carRacing.getCarList()));
            round.reduceRound();
        }

        resultView.printOutRacingResult();
    }
}
