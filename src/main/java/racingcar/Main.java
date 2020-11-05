package racingcar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        String nameCsv = inputView.askCars();
        int maxRaceNum = inputView.askMaxRaceNum();

        RacingGame game = new RacingGame(nameCsv, maxRaceNum);
        game.play();

        RacingView racingView = RacingView.getInstance();
        racingView.printResultMsg();

        List<List<Car>> history = game.getHistory();
        racingView.printHistory(history);

        List<Car> winners = game.getWinners();
        racingView.printWinners(winners);
    }
}
