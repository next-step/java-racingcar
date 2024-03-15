package racing;

import java.util.Arrays;

import static racing.InputView.inputCarCount;
import static racing.InputView.inputTryCount;
import static racing.ResultView.printResult;

public class RacingMain {
    public static void main(String[] args) {
        int carCount = inputCarCount();
        int tryCount = inputTryCount();

        String[] carPosition = new String[carCount];
        Arrays.fill(carPosition, "-");

        System.out.println();
        printResult(carCount, tryCount, carPosition);
    }
}
