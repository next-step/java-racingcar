package step3;

public class RacingGameMain {

    public static void main(String[] args) throws InterruptedException {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        RacingGame racingGame = new RacingGame(inputView.enterTime(), inputView.enterCarCount());

        System.out.println("실행결과");
        for (int i = 0; i < racingGame.getTime(); ++i) {
            resultView.printResult(racingGame.move());
            Thread.sleep(1000);
            System.out.println();
        }
    }
}
