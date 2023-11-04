package step3;

public class Runner {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputNumberOfCars();
        inputView.inputNumberOfTry();

        Game game = new Game(inputView.numberOfCars(), inputView.numberOfTry());
        game.play();
    }

}
