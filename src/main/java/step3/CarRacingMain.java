package step3;


import static step3.InputView.*;
import static step3.ResultView.*;

public class CarRacingMain {
    public static void main(String[] args) {

        Game game = new Game();
        result(game.play(inputCarName(), inputGameCount()));
    }
}