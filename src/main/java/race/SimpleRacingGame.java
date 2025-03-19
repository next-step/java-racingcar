package race;

public class SimpleRacingGame {
    public static void main(String[] args) {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        int numOfCars;
        do {
            numOfCars = InputView.getNumberInput("자동차 대수는 몇 대 인가요? (1-10):");
        } while (!racingTrack.validateCarCount(numOfCars));

        int numOfAttempts;
        do {
            numOfAttempts = InputView.getNumberInput("시도할 회수는 몇 회 인가요? (1-10):");
        } while (!racingTrack.validateAttemptCount(numOfAttempts));

        racingTrack.startRace(numOfCars, numOfAttempts);
    }
}
