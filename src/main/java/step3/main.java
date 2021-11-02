package step3;

public class main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Rule rule = inputView.input();

        Game game = Game.of(rule);
        game.start();

        ResultView resultView = ResultView.from(game.getGameHistory(), rule);
        resultView.view();
    }
}
