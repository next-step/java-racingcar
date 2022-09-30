package step3;

import java.util.List;

public class GameRunner {
    public static void main(String[] args) {
        EnterGameConfig enterGameConfig = new EnterGameConfig();
        String[] carNames = enterGameConfig.enterCarNames();
        int iterate = enterGameConfig.enterIterate();

        Racing racing = new Racing(carNames, iterate);
        racing.start();
        List<String> winners = racing.getWinners();

        ResultPrinter resultView = new ResultPrinter(iterate);
        resultView.printRecord(racing.getRacingRecordOfCars());
        resultView.printWinner(winners);
    }
}
