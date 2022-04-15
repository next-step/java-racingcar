package racingcar;

public class RacingCarApplication {
    public static void main(String[] args) {
        inputView.Input input = inputView.entry();

        RacingCar[] racingCars = RacingCar.createBatch(input.numOfCar);
        RacingCarGame game = new RacingCarGame(racingCars, input.numOfRound, new RandomNumCondition());
        game.start();
    }
}
