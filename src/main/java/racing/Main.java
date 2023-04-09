package racing;

import static racing.InputView.inputCount;
import static racing.ResultView.resultCars;

public class Main {
    public static void main(String[] args) {
        int carCount = getCarCount("자동차 대수는 몇대인가요?");

        int racingCount = getCarCount("시도할 회수는 몇 회 인가요?");

        resultCars(carCount, racingCount);
    }

    private static int getCarCount(String x) {
        System.out.println(x);
        int carCount = inputCount();
        return carCount;
    }
}
