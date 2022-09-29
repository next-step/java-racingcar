package racingcar;

public class App {
    public static void main(String[] args) {
        int count = InputView.requestInputCount();
        int repeat = InputView.requestInputRepeat();
        ResultView.println();

        Game game = new Game(count, repeat);
        game.start();
    }
}
