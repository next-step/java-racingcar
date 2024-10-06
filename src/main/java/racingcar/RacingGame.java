package racingcar;

public class RacingGame {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarName();
        Race race = new Race(carNames);
        int racingCount = InputView.getRacingCount();
        race.run(racingCount);
    }
}
