package step3;

public class Runner {

    public static void main(String[] args) {
        int numberOfCars = InputView.numberOfCars();
        int numberOfTry = InputView.numberOfTry();

        RacingGame game = new RacingGame(CarGenerator.generate(numberOfCars), numberOfTry);
        game.play();
    }

}
