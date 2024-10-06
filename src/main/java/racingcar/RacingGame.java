package racingcar;

public class RacingGame {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarName();
        int racingCount = InputView.getRacingCount();
        Race race = new Race(carNames);
        race.run(racingCount);
    }
}
