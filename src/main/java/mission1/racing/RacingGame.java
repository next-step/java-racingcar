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

        for(int i = 0; i < time; i++) {
            movement.move();
        }
    }

    private void setGame() {
        String inputName = inputView.inputView("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = inputName.split(",");
        time = Integer.parseInt(inputView.inputView("시도할 회수는 몇 회 인가요?"));

        movement = new Movement(names);
    }
}
