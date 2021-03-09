package RacingCar;

public class RacingCarMain {
    public static void main(String[] args) {
        final int MOVE_THRESHOLD = 4;
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfRacing = inputView.getNumberOfRacing();

        outputView.printTitle();
        Racing racing = new Racing(new RandomMovementCondition(MOVE_THRESHOLD), numberOfCars, numberOfRacing);
        racing.addEndOfSingleRacingListener(new Observer<RacingResult>() {
            @Override
            public void observe(RacingResult event) {
                outputView.printSingleRacingResult(event);
            }
        });
        racing.racing();
    }
}
