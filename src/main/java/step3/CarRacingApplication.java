package step3;

public class CarRacingApplication {

    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            inputView.inputCarsName();
            inputView.inputRoundsCount();

            CarRacing carRacing = new CarRacing(inputView.getCarsName());
            Round round = new Round(inputView.getRoundsCount());

            ResultView resultView = new ResultView();
            while (round.isRoundContinue()) {
                carRacing.moveForward();
                resultView.addCarRacingResult(new CarResultDto(carRacing.getCarList()));
                round.reduceRound();
            }

            resultView.printOutRacingResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
