package racingcar.step3_4;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String COMMA_SEPERATOR = ",";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final InputValidator INPUT_VALIDATOR = new InputValidator();

    public InputView() {
    }

    public GameAttribute getGameAttribute() {
        return new GameAttribute(getRacingCarNames(), getTryCount());
    }

    private Names getRacingCarNames() {
        printCarNamesInputRequestMessage();
        return getInputToNames();
    }

    private Names getInputToNames() {
        String inputValue = SCANNER.nextLine();
        INPUT_VALIDATOR.isBlank(inputValue);

        return Names.of(inputValue.split(COMMA_SEPERATOR));
    }

    private void printCarNamesInputRequestMessage() {
        System.out.println(CAR_NAMES_MESSAGE);
    }

    private int getTryCount() {
        printTryCountInputRequestMessage();
        return getInputToInt();
    }

    private void printTryCountInputRequestMessage() {
        System.out.println(TRY_COUNT_MESSAGE);
    }

    private int getInputToInt() {
        String inputValue = SCANNER.nextLine();

        return convertToInt(inputValue);
    }

    private int convertToInt(String value) {
        int intValue;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
        INPUT_VALIDATOR.isZeroOrNegative(intValue);

        return intValue;
    }
}
