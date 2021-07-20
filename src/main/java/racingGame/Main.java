package racingGame;

public class Main {

    public static void main(String[] args) {
        int carSize = InputView.inputCarSize();
        int repeatCount = InputView.inputRepeatCount();

        Game game = new Game(carSize, repeatCount);
        System.out.println("실행결과");
        for (int i = 0; i < repeatCount; i++) {
            game.runOnce();
            ResultView.printResult(game.getCarsStatus());
        }
    }
}
