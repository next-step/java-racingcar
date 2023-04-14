package study.racingcar;

public class GameController {
    /**
     * 게임 실행을 담당한다
     */
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        GameBoard racingCarGame = new GameBoard(inputView, outputView);
        racingCarGame.run();
    }
}
