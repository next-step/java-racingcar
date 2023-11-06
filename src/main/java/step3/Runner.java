package step3;

public class Runner {

    public static void main(String[] args) {
        String nameOfCars = InputView.nameOfCars();
        int numberOfTry = InputView.numberOfTry();

        RacingGame game = new RacingGame(CarGenerator.generate(nameOfCars), numberOfTry);
        game.play();
    }

}
