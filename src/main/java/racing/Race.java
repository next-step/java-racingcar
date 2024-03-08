package racing;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final InputView inputView;

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public Race(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        int carCount = inputView.inputtedNumber(CAR_COUNT_MESSAGE);
        int tryCount = inputView.inputtedNumber(TRY_COUNT_MESSAGE);
        inputView.closeScanner();

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }

        ResultView resultView = new ResultView();

        int currentTryCount = 0;
        while (currentTryCount < tryCount) {
            playRound(carList);
            resultView.printRaceResult(carList);
            currentTryCount++;
        }
    }

    private void playRound(List<Car> carList) {
        for (Car car : carList) {
            randomAndForward(car);
        }
    }

    private void randomAndForward(Car car) {
        if (Judgement.isNumberGreaterThanFour(RandomUtil.randomNumberZeroToNine())) {
            car.forward();
        }
    }
}
