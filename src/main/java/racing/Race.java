package racing;

import racing.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final InputView inputView;
    private final MoveStrategy moveStrategy;

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public Race(InputView inputView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        int carCount = inputView.inputtedNumber(CAR_COUNT_MESSAGE);
        int tryCount = inputView.inputtedNumber(TRY_COUNT_MESSAGE);
        inputView.closeScanner();

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }

        Cars cars = new Cars(carList);

        ResultView resultView = new ResultView();

        int currentTryCount = 0;

        while (currentTryCount < tryCount) {
            playRound(cars);
            resultView.printRaceResult(cars);
            currentTryCount++;
        }
    }

    private void playRound(Cars cars) {
        for (Car car : cars) {
            car.play(moveStrategy);
        }
    }
}
