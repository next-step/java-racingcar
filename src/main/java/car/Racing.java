package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.carCountQuestion();
        int attemptCount = inputView.attemptCountQuestion();

        CarRacing carRacing = new CarRacing(carCount, attemptCount);
        List<Car> result = carRacing.start();

        ResultView resultView = new ResultView(result);
        resultView.print();
    }
}
