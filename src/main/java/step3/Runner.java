package step3;

import static step3.util.StringUtil.splited;

public class Runner {

    public static void main(String[] args) {
        String[] nameOfCars = splited(InputView.nameOfCars());
        int numberOfTry = InputView.numberOfTry();

        RacingGame game = new RacingGame(CarGenerator.generate(nameOfCars), numberOfTry);
        game.play();
    }

}
