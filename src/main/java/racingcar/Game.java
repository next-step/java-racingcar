package racingcar;

public class Game {
    private static final InputView INPUT_VIEW = new InputView();
    private static final ResultView RESULT_VIEW = new ResultView();

    public static void main(String args[]){
        GameController gameController = new GameController(INPUT_VIEW, RESULT_VIEW);
        gameController.play();
    }
}
