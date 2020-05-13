package step3;

public class RacingGameMain {

    public static void main(String[] args) throws InterruptedException {

        InputView inputView = new InputView();
        inputView.inputCarCount();
        inputView.inputTime();

        ResultView resultView = new ResultView();

        RacingGame racingGame = new RacingGame(inputView.getTime(), inputView.getCarCount());

        System.out.println("실행결과");
        for (int i = 0; i < inputView.getTime(); ++i) {
            resultView.printResult(racingGame.move());
            Thread.sleep(1000);
            System.out.println();
        }
    }
}
