package racing;

import racing.view.IntegerInputView;
import racing.view.InteractiveInputView;

import java.util.ArrayList;
import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {
        InteractiveInputView<Integer> carSizeInputView = new IntegerInputView("자동차 대수는 몇 대 인가요?");
        InteractiveInputView<Integer> movesInputView = new IntegerInputView("시도할 회수는 몇 회 인가요?");
        ResultView resultView = new ResultView();

        int carSize = carSizeInputView.getUserInput();
        int moves = movesInputView.getUserInput();

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carSize; i++) {
            carList.add(new RandomlyMovingCar());
        }

        Racing racing = new Racing(carList, resultView, moves);
        racing.start();
    }

}
