package racing;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final InputView inputView;

    public Race(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        int carCount = inputView.inputtedCarCount();
        int tryCount = inputView.inputtedTryCount();
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
