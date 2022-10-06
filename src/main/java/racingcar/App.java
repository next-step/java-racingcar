package racingcar;

public class App {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        String[] names = InputView.requestInputNames();
        int repeat = InputView.requestInputRepeat();

        Game game = new Game(names, repeat);
        game.start();
    }
}
