package step3;


import static step3.InputView.*;

public class CarRacingMain {
    public static void main(String[] args) {

        Game game = new Game();
        game.play(inputCarCount(), inputGameCount());

        ResultView.result(game.showGameResult());
    }
}