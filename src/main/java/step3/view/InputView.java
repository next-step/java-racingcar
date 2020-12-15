package step3.view;

public class InputView {
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_ROUND_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public int getCarCount() {
        printCarCountMessage();
        return ViewUtils.nextInt();
    }

    private void printCarCountMessage() {
        ViewUtils.printLine(INPUT_CAR_COUNT_MESSAGE);
    }

    public int getRoundCount() {
        printRoundCountMessage();
        return ViewUtils.nextInt();
    }

    private void printRoundCountMessage() {
        ViewUtils.printLine(INPUT_ROUND_COUNT_MESSAGE);
    }

}
