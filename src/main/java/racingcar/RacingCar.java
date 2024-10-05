package racingcar;

public class RacingCar {
    public static void main(String[] args) {
        Race race = new Race(InputView.inputCarCount());
        ResultView.printResult(race, InputView.inputLoop());
    }
}
