package racingcar;

import racingcar.view.InputView;

public class RacingCarMain {

    public final static String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public final static String DRIVE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        String carNames = InputView.inputString(CAR_NAME_INPUT_MESSAGE);
        int driveCount = InputView.inputInteger(DRIVE_COUNT_INPUT_MESSAGE);

        System.out.println();
        System.out.println("실행 결과");

        Game game = new Game(carNames, driveCount);
        for (int i = 0; i < game.getDriveCount(); i++) {
            game.playingDrive();
            game.printProgress();
        }
    }
}
