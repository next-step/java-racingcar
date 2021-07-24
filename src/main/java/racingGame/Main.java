package racingGame;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Car> cars = InputView.inputCarNames();
        int repeatCount = InputView.inputRepeatCount();

        Game game = new Game(cars, repeatCount);

        ResultView.printGameStart();
        for (int i = 0; i < repeatCount; i++) {
            List<Integer> randomNumbers = RandomNumber.makeRandomNumber(cars.size());
            game.runOnce(randomNumbers);
            ResultView.printResult(game.getCars());
        }
        List<Car> winners = game.findWinner();
        ResultView.printWinnerMessage(winners);
    }
}
