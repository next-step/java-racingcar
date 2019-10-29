package winner;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 22:22
 */
public class CarRaceInputView {


    private static final String DELIMITER = ",";
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_GAME_ROUND = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner;

    public CarRaceInputView() {
        this.scanner = new Scanner(System.in);
    }

    public CarRaceInputView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public String[] inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        final String names = scanner.nextLine();
        if (CheckUtil.stringNullOrEmpty(names)) {
            throw new InputMismatchException("null 이거나 공백 문자열은 입력이 불가능합니다.");
        }
        return names.split(DELIMITER);
    }

    public int inputGameRound() {
        System.out.println(INPUT_GAME_ROUND);

        String inputGameRound = scanner.nextLine();
        if (CheckUtil.isNumber(inputGameRound)) {
            throw new InputMismatchException("숫자만 입력 가능합니다.");
        }

        int gameRound = Integer.parseInt(inputGameRound);
        if (!CheckUtil.greaterThanZero(gameRound)) {
            throw new InputMismatchException("0보다 큰 숫자만 입력이 가능합니다.");
        }

        return gameRound;
    }
}
