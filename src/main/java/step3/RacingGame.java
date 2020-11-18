package step3;

import java.util.ArrayList;
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

        makeCarList(carNumber);
    }

    private void makeCarList(int carNumber) {
        carList = new ArrayList<>();

        for (int i = 0; i < carNumber; i++) {
            Car car = new Car(0);
            carList.add(car);
        }
    }

}
