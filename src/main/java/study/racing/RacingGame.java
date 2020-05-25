package study.racing;

import study.racing.model.Car;
import study.racing.model.Participants;
import study.racing.view.InputView;
import study.racing.view.ResultView;

public class RacingGame {
    private static final int START_POSITION = 0;

    private final InputView inputView;
    private final ResultView resultView;
    private final Participants participants;

    private int time;

    public RacingGame() {
        inputView = new InputView();
        resultView = new ResultView();
        participants = new Participants();
    }

    public void play() {
        configureGameSettings();

        System.out.println("\n실행 결과\n");

        for(int i=0; i<time; i++) {
            participants.move();
            resultView.printCarPositions(participants.getParticipants());
        }

        resultView.printWinners(participants.getWinners());
    }

    private void configureGameSettings() {
        String[] carNames = inputView.scanCarNames();
        time = inputView.scanTime();

        for(String carName : carNames) {
            participants.addParticipant(new Car(carName, START_POSITION));
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }
}
