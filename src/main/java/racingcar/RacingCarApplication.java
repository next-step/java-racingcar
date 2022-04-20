package racingcar;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView.Input input = InputView.entry();

        RacingCar[] racingCars = RacingCar.createBatch(input.getCarNames());
        RacingCarGame game = new RacingCarGame(racingCars, input.getNumOfRound(), new RandomNumCondition(new RandomGenerator(0, 9)));

        game.start();
    }
}
