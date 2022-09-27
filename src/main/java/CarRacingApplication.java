public class CarRacingApplication {

    public static void main(String[] args) {
        CarRacingExecutor carRacingExecutor = InputView.inputCarRacingInformation();

        while (carRacingExecutor.useRemainCount()) {
            ResultView.printCarRacingResult(carRacingExecutor);
            carRacingExecutor.proceedNextRound();
        }
    }
}
