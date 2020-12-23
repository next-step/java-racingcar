package step3.view;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String CAR_NAMES_DELIMITER = ",";

    public String[] getCarNames() {
        printCarNamesMessage();

        return ViewUtils.nextLine()
                .split(CAR_NAMES_DELIMITER);
    }

    private void printCarNamesMessage() {
        ViewUtils.printLine(INPUT_CAR_NAMES_MESSAGE);
    }

    public int getRoundCount() {
        printRoundCountMessage();
        return ViewUtils.nextInt();
    }

    private void printRoundCountMessage() {
        ViewUtils.printLine(INPUT_ROUND_COUNT_MESSAGE);
    }
}
