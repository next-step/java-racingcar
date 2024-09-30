package race;

import java.util.ArrayList;
import java.util.List;

public class playGame {

    public static final int INITIAL_LOCATION = 1;

    public static void main(String[] args) {
        InputView.inputCarView();
        int carNum = InputView.inputCarNumber();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car(i, INITIAL_LOCATION));
        }

        InputView.inputMoveView();
        int moveNum = InputView.inputMovementNumber();
        resultView.printResultView();

    }
}
