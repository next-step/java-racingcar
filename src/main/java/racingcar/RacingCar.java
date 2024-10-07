package racingcar;

public class RacingCar {
    public static void main(String[] args) {
        Cars cars = Cars.fromCarNames(InputView.inputCarNames());
        ResultView.printResult(cars, InputView.inputLoop());
        ResultView.printWinners(cars.getWinners());
    }
}
