package racing;

import racing.view.InputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.getUserInput();
        RacingCarGame racingCarGame = new RacingCarGame(inputView.getNumCars());
        racingCarGame.run(inputView.getNumMoves());
    }
}

