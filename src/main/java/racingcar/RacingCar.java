package racingcar;

public class RacingCar {
    public static void main(String[] args) {
        Race race = Race.fromCarNames(InputView.inputCarNames());
        ResultView.printResult(race, InputView.inputLoop());
        ResultView.printWinners(race.getWinners());
    }
}
