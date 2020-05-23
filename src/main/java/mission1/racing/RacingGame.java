package mission1.racing;

import mission1.racing.view.RacingGameInputView;
import mission1.racing.view.RacingGameOutputView;

public class RacingGame {
    private int time;
    private int carNumber;

    private Movement movement;
    private RacingGameInputView inputView = new RacingGameInputView();

    public void startGame() {
        setGame();

        for(int i = 0; i < time; i++) {
            movement.move();
        }
    }

    private void setGame() {
        time = inputView.inputView("시도할 회수는 몇 회 인가요?");
        carNumber = inputView.inputView("자동차 대수는 몇 대 인가요?");

        movement = new Movement(carNumber);
    }
}
