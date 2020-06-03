package step4;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String names = inputView.getNames();
        int rounds = inputView.getRound();
        RaceGame game = new RaceGame(new Cars(names), new Round(rounds));
        GameResult result = game.start();
        ResultView resultView = new ResultView();
        resultView.showResult(result);
    }
}
