package racingcar;


public class RacingMain {
    public static void main(String[] args) {
        InputView input = new InputView();
        String[] names = input.getNames();
        RacingResult resultView = new RacingResult(new RacingGame(names), input.getTryNo());
        resultView.printBattle();
        resultView.printWinner();
    }
}
