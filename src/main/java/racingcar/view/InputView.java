package racingcar.view;

import java.util.Scanner;
import racingcar.domain.car.Participants;
import racingcar.domain.car.Turn;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER = ",";

    public static String getConsoleTextFrom(final String message) {
        OutputView.printMessage(message);
        return scanner.nextLine().trim();
    }

    public static Participants setNames() {
        try {
            String names = getConsoleTextFrom(NAME_MESSAGE);
            return Participants.createCars(names.split(DELIMITER));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return setNames();
        }
    }

    public static Turn setTurnCount() {
        try {
            String turn = getConsoleTextFrom(TURN_MESSAGE);
            return Turn.createTurn(turn.trim());
        } catch (NumberFormatException | IllegalStateException e) {
            e.printStackTrace();
            return setTurnCount();
        }
    }
}
