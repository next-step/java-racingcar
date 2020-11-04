package racingcar;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();

        String nameCsv = inputView.askCars();
        int tryNum = inputView.askTryNum();
        RacingGame game = new RacingGame(nameCsv, tryNum);

        RacingView racingView = RacingView.getInstance();
        racingView.printResultMsg();

        while (game.checkNotGameOver()) {
            game.play();
        }

        List<List<Car>> history = game.getHistory();
        for (List<Car> cars : history) {
            racingView.printCars(cars);
        }
        racingView.printWinners(game.getWinners());
    }
}
