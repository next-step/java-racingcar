package racingcar;

public class App {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int count = InputView.requestInputCount();
        int repeat = InputView.requestInputRepeat();

        Game game = new Game(count, repeat);
        game.start();
    }
}
