package racing;

public class RacingGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String names = inputView.readCarNames();
        int moveCount = inputView.readMoveCount();

        try {
            Racing racing = new Racing(names, moveCount, new RandomNumberGenerator());
            outputView.startPrintResult();
            while (!racing.isEnd()) {
                racing.play();
                outputView.printResult(racing.getRoundResult());
            }
            outputView.printWinners(racing.getRoundResult());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
