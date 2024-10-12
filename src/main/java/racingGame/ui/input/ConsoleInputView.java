package racingGame.ui.input;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleInputView implements InputView{

    private static final String UNIQUE_POSITIVE_NUMBER_ERROR_MESSAGE = "하나의 양의 정수를 입력해주세요!";
    private static final String COMMA_SEPARATOR_ERROR_MESSAGE = ", 를 구분자로 입력해주세요!";
    private static final String CAR_NAMES_INIT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVE_COUNT_INIT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String SEPARATOR = ",";
    private static final Pattern CommaSeparatedPattern = Pattern.compile("^(\\w+)(,\\w+)*$");
    private static final Pattern UniquePositiveNumberPattern = Pattern.compile("^\\d+$");
    private Scanner input;

    public ConsoleInputView() {
        input = new Scanner(System.in);
    }

    @Override
    public String[] getCarNames() {
        System.out.println(CAR_NAMES_INIT_MESSAGE);
        String carNames = input.nextLine();
        validateCommaSeparatedPattern(carNames);
        return carNames.split(SEPARATOR);
    }

    private void validateCommaSeparatedPattern(String carNames) {
        if (!CommaSeparatedPattern.matcher(carNames).matches()) {
            throw new IllegalArgumentException(COMMA_SEPARATOR_ERROR_MESSAGE);
        }
    }

    private void validateUniquePositiveNumber(int number) {
        if (!UniquePositiveNumberPattern.matcher(Integer.toString(number)).matches()) {
            throw new IllegalArgumentException(UNIQUE_POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    @Override
    public int getMoveCount() {
        System.out.println(MOVE_COUNT_INIT_MESSAGE);
        int moveCount = input.nextInt();
        validateUniquePositiveNumber(moveCount);
        return moveCount;
    }

}