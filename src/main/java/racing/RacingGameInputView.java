package racing;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-28 00:09
 */
public class RacingGameInputView {

    private final Scanner scanner;
    private static final String CAR_INPUT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_ATTEMPT_ROUND_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");
    private static final int MIN_VALUE = 0;

    public RacingGameInputView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public int getNumberOfCars() {
        return getInputValue(CAR_INPUT_QUESTION);
    }

    public int getNumberOfRound() {
        return getInputValue(GAME_ATTEMPT_ROUND_QUESTION);
    }


    private int getInputValue(String inputQuestion) {
        System.out.println(inputQuestion);
        String inputString = scanner.nextLine();
        if (!isNumber(inputString)) {
            throw new InputMismatchException("숫자만 입력 가능합니다.");
        }

        int parseIntValue = Integer.parseInt(inputString);
        if (!checkMinValue(parseIntValue)) {
            throw new InputMismatchException("0보다 큰 숫자만 입력이 가능합니다.");
        }
        return parseIntValue;
    }


    private boolean isNumber(String str) {
        return str != null && NUMERIC.matcher(str).matches();
    }

    private boolean checkMinValue(int cars) {
        return cars > MIN_VALUE;
    }
}
