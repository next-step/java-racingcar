package racing;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.requestNumberOfCar();
        int numberOfMove = inputView.requestNumberOfMove();
        CarGenerator generator = new CarGenerator();
        Cars cars = generator.generateCar(numberOfCars);
        GameRunner gameRunner = new GameRunner(cars, numberOfMove);
        RandomNumberGenerator randomNumberGenerator = new CarRandomNumberGenerator();
        gameRunner.play(randomNumberGenerator);
    }
}
