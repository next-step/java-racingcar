package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarMain {

    public final static String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public final static String DRIVE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        ResultView.println(CAR_NAME_INPUT_MESSAGE);
        String carNames = InputView.inputCarNames();
        ResultView.println(DRIVE_COUNT_INPUT_MESSAGE);
        int driveCount = InputView.inputDriveCount();

        ResultView.println("");
        ResultView.println("실행 결과");

        Game game = new Game(carNames, driveCount);
        for (int i = 0; i < game.getDriveCount(); i++) {
            game.playingDrive();
            ResultView.pirntProgress(game.getCars());
            ResultView.println("");
        }

        ResultView.printWinners(game.getWinners().getCarNames());
    }
}
