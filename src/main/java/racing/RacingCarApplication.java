package racing;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.requestNumberOfCar();
        int numberOfMove = inputView.requestNumberOfMove();
        Cars cars = new Cars();
        cars.generate(numberOfCars);
        GameRunner gameRunner = new GameRunner(cars, numberOfMove);
        RandomNumberGenerator randomNumberGenerator = new CarRandomNumberGenerator();
        gameRunner.play(randomNumberGenerator);
    }
}
