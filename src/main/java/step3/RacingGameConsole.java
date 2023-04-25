package step3;

public class RacingGameConsole {

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int moveCount = InputView.inputMoveCount();
        Racing racingGame = new Racing(carCount, moveCount);

        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            racingGame.run();
            OutputView.printCarPosition(racingGame.getCars());
        }
    }

}
