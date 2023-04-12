package racingcar;

public class ConsoleOutput implements Output {
    private static final String ONE_POSITION_MARK = "-";
    private static final String EXECUTION_HEADER = "\n실행 결과";

    public void printPosition(Integer position) {
        System.out.println(ONE_POSITION_MARK.repeat(position));
    }

    public void printExecutionHeader() {
        System.out.println(EXECUTION_HEADER);
    }

    public void printBlankLine() {
        System.out.println();
    }
}
