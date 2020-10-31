package racingcar;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(new ConsoleInputView(), new ConsoleInputDevice());
        RacingCarGame racingCarGame = new RacingCarGame(inputHandler, new ConsoleResultView());
        racingCarGame.game();
    }
}
