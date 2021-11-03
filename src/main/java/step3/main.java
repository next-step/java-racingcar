package step3;

public class main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Rule rule = inputView.input();

        MoveStrategy moveStrategy = new RandomMoveStrategy();
        Game game = Game.of(rule, moveStrategy);
        game.start();

        ResultView resultView = ResultView.from(game.getGameHistory(), rule);
        resultView.view();
    }
}
