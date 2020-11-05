package racingcar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        String nameCsv = inputView.askNames();
        int maxRaceNum = inputView.askMaxRaceNum();

        RacingGame game = new RacingGame(nameCsv, maxRaceNum);
        game.play();

        OutputView outputView = OutputView.getInstance();
        outputView.printResultMsg();

        List<List<Car>> history = game.getHistory();
        outputView.printHistory(history);

        List<Car> winners = game.getWinners();
        outputView.printWinners(winners);
    }
}
