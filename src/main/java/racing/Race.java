package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Race {

    public void start() {
        InputView inputView = new InputView(new Scanner(System.in));
        int carCount = inputView.inputtedCarCount();
        int tryCount = inputView.inputtedTryCount();

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }

        ResultView resultView = new ResultView();

        int currentTryCount = 0;
        while (currentTryCount <= tryCount) {
            for (Car car : carList) {
                if (Judgement.isNumberGreaterThanFour(RandomUtil.randomNumberZeroToNine())) {
                    car.forward();
                };
            }

            resultView.printRaceResult(carList);
            currentTryCount++;
        }

    }
}
