package racing;

import static racing.InputView.inputCount;
import static racing.ResultView.resultCars;

public class Main {
    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇대인가요?");
        int carCount = inputCount();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int racingCount = inputCount();

        resultCars(carCount, racingCount);
    }
}
