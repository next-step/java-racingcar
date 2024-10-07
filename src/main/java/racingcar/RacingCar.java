package racingcar;

public class RacingCar {
    public static void main(String[] args) {
        Cars cars = Cars.fromCarNames(InputView.inputCarNames());
        ResultView.printRaceResults(cars.runRace(InputView.inputLoop()));
        ResultView.printWinners(cars.getWinners());
    }
}
