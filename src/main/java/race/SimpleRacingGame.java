package race;

public class SimpleRacingGame {
    public static void main(String[] args) {
        int numOfCars = InputView.getNumberInput("자동차 대수는 몇 대 인가요? (1-10): ", 1, 10);
        int numOfAttempts = InputView.getNumberInput("시도할 회수는 몇 회 인가요? (1-10): ", 1, 10);

        RacingTrack racingGame = new RacingTrack(numOfCars, numOfAttempts);
        racingGame.startRace();
    }
}
