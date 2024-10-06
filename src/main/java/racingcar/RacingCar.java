package racingcar;

public class RacingCar {
    public static void main(String[] args) {
        Race race = new Race(InputView.inputCarNames());
        ResultView.printResult(race, InputView.inputLoop());
    }
}
