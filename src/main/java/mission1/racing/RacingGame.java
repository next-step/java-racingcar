package mission1.racing;

import mission1.racing.view.RacingGameInputView;
import mission1.racing.view.RacingGameOutputView;

public class RacingGame {
    private int time;

    private Movement movement;
    private RacingGameInputView inputView = new RacingGameInputView();
    private RacingGameOutputView outputView = new RacingGameOutputView();

    public void announceWinner() {
        startGame();
        outputView.winnerView(movement.selectWinner());
    }

    private void startGame() {
        setGame();

        for (int i = 0; i < time; i++) {
            movement.move();
        }
    }

    private void setGame() {
        String inputName = inputView.inputCarsNameView();
        String[] names = inputName.split(",");
        time = inputView.inputNumOfCarsView();

        movement = new Movement(names);
    }
}
