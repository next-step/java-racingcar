package racingGame.ui.input;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleInputView implements InputView{

    private static final String UNIQUE_POSITIVE_NUMBER_ERROR_MESSAGE = "하나의 양의 정수를 입력해주세요!";
    private static final String CAR_COUNT_INIT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String MOVE_COUNT_INIT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final Pattern UniquePositiveNumberPattern = Pattern.compile("^\\d+$");
    private Scanner input;

    public ConsoleInputView() {
        input = new Scanner(System.in);
    }

    @Override
    public int getCarCount() {
        System.out.println(CAR_COUNT_INIT_MESSAGE);
        int carCount = input.nextInt();
        validateUniquePositiveNumber(carCount);
        return carCount;
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