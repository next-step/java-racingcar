package race;

import race.domain.Cars;
import race.view.InputView;

public class RacingGameMain {

    public static void main(String[] args) {
        int numbers = InputView.askNumberOfCars();
        int attempts = InputView.askNumberOfAttempts();
        RacingGame game = new RacingGame(new Cars(numbers));
        game.start(numbers, attempts);
    }

}
