package step3;

public class main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Rule rule = inputView.input();

        int move_condition = 4;
        NumberGenerator numberGenerator = new RandomNumberGenerator(10);

        MoveStrategy moveStrategy = new RandomMoveStrategy(move_condition, numberGenerator);

        Game game = Game.of(rule, moveStrategy);
        game.start();

        ResultView resultView = ResultView.from(game.getGameHistory(), rule);
        resultView.view();
    }
}
