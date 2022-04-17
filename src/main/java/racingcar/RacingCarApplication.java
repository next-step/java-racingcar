package racingcar;

public class RacingCarApplication {
    public static void main(String[] args) {
        inputView.Input input = inputView.entry();

        RacingCar[] racingCars = RacingCar.createBatch(input.getNumOfCar());
        RacingCarGame game = new RacingCarGame(racingCars, input.getNumOfRound(), new RandomNumCondition());
        game.start();
    }
}
