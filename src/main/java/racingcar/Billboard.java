package racingcar;

public class Billboard {

    private final static String SEPARATOR = "-";
    private final static String NOTICE_MENT = "실행 결과";

    private Billboard() {
    }

    public static void printGameResult(final GameResult gameResult) {
        notice();
        for (final RoundResult roundResult : gameResult.getResult()) {
            printRoundResult(roundResult);
            lineBreak();
        }
    }

    private static void printRoundResult(final RoundResult roundResult) {
        for(final Integer position : roundResult.getResult()) {
            printPosition(position);
            lineBreak();
        }
    }

    private static void printPosition(final Integer position) {
        for (int i = 0; i < position; i++) {
            StringBuilder positionSeparator = new StringBuilder();
            positionSeparator.append(SEPARATOR);
            System.out.print(positionSeparator);
        }
    }

    private static void notice() {
        System.out.println(NOTICE_MENT);
    }

    private static void lineBreak() {
        System.out.println();
    }

}
