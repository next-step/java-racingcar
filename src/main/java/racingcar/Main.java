package racingcar;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int carCount = inputView.inputCarCount();
        int tryCount = inputView.inputTryCount();
        List<Car> cars = GenerateCarUtils.generateCars(carCount);
        ResultView resultView = new ResultView();
        RacingCarService racingCarService = new RacingCarService(cars, tryCount, resultView);
        racingCarService.process();
    }
}
