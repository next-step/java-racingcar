package step3;

import step3.game.GameController;
import step3.view.input.ConsoleInputView;
import step3.view.output.ConsoleOutputView;

public class Step3Application {
    public static void main(String[] args) {
        GameController game = new GameController(new ConsoleInputView(), new ConsoleOutputView());
        game.start();
    }
}
