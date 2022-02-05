package racingcar.view;

import java.util.Scanner;
import racingcar.domain.dto.ParticipantsRequestDto;
import racingcar.domain.dto.TurnRequestDto;

public class InputView {

    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER = ",";
    private static final String ERROR_LOG = "빈 공백은 들어올 수 없습니다.";
    private static final String ENTER = "\n";

    private static Scanner scanner = new Scanner(System.in);

    private static String getConsoleTextFrom(final String message) {
        OutputView.printMessage(message + ENTER);
        String line = scanner.nextLine().trim();
        try {
            validateInput(line);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getConsoleTextFrom(message);
        }
        return line;
    }

    public static ParticipantsRequestDto setNames() {
        String names = getConsoleTextFrom(NAME_MESSAGE);
        return new ParticipantsRequestDto(names.split(DELIMITER));
    }

    public static TurnRequestDto setTurnCount() {
        String turn = getConsoleTextFrom(TURN_MESSAGE);
        return new TurnRequestDto(turn);
    }

    private static void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_LOG);
        }
    }
}
