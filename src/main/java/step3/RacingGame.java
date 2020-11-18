package step3;

import java.util.List;

public class RacingGame {

    private int carNumber;
    private int round;
    private List<Car> carList;

    public void startGame() {
        InputView inputView = new InputView();

        inputView.init();
        inputView.showInputCarMessage();
        carNumber = inputView.inputCarNumber();

        inputView.showInputRoundMessage();
        round = inputView.inputRound();
    }

}
