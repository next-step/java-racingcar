package racingcar;


public class RacingMain {
    public static void main(String[] args) {
        InputView input = new InputView();
        RacingGame racingGame = new RacingGame(input.getNames(), input.getTryNo());
        RacingResult result = null;
        while (!racingGame.isEnd()) {
            result = racingGame.race();
            ResultView.printBattle(result);
        }
        ResultView.printWinners(result);
    }
}
