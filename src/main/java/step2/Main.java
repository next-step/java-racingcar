package step2;

public class Main {
    public static void main(String[] args) {
        final GameRunner gameRunner = new StandardInputView().makeGameRunner();
        final GameResult gameResult = gameRunner.simulate();
        final String output = new GameResultNamedWinnerStringFormatter(".").format(gameResult);

        new StandardOutputView().print(output);
    }
}
