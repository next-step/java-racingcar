package step3.ui;

import step3.ui.dto.RequestRacingGame;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;
import static step3.util.Validator.*;

/**
 * 사용자의 입력을 받기 위한 클래스
 */
public class InputView {

    public static final String GUIDE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String GUIDE_HOW_MANY_TRY = "시도할 회수는 몇회인가요?";
    public static final String SPLIT_DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    // 사용자 입력
    public RequestRacingGame requestUserInput() {

        // 자동차 이름 받기
        String[] carNames = requestUserName();
        int attemptCount = requestAttemptCount();

        return new RequestRacingGame(carNames, attemptCount);
    }

    // 사용자 입력 값이 숫자가 아닌 경우 재입력 처리
    private String[] requestUserName() {
        out.println(GUIDE_INPUT_CAR_NAMES);
        String participantNames = scanner.nextLine();
        // 분리가 가능한 문자열
        if(!isNullAndIsBlank(participantNames)
                && isValidNames(participantNames)
                && !greaterThenNameMaxLength(participantNames)) {
            return participantNames.split(SPLIT_DELIMITER);
        }
        return requestUserName();
    }

    private boolean greaterThenNameMaxLength(String participantNames) {
        String[] names = participantNames.split(SPLIT_DELIMITER);
        return Arrays.stream(names)
                .anyMatch(s -> s.length() > 5);
    }

    // 라운드 수를 입력 받으려는 경우 숫자로 파싱이 되는지 확인
    private int requestAttemptCount() {
        out.println(GUIDE_HOW_MANY_TRY);
        String attemptCount = scanner.nextLine();

        if(isNumeric(attemptCount)) {
            return Integer.parseInt(attemptCount);
        }
        return requestAttemptCount();
    }
}
