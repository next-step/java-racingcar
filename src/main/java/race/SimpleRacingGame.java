package race;

public class SimpleRacingGame {
    public static void main(String[] args) {
        RacingTrack racingTrack = new RacingTrack(10, 10);

        String[] carNames;
        do {
            carNames = InputView.getStringInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분):", ",");
        } while (!racingTrack.validateCarNames(carNames));

        int numOfAttempts;
        do {
            numOfAttempts = InputView.getNumberInput("시도할 회수는 몇 회 인가요? (1-10):");
        } while (!racingTrack.validateAttemptCount(numOfAttempts));

        racingTrack.startRace(carNames, numOfAttempts);
        ResultView.printRaceWinners(racingTrack.getWinners());
    }
}
