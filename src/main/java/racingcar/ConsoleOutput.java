package racingcar;

public class ConsoleOutput implements Output {
    private static final String ONE_POSITION_MARK = "-";
    private static final String EXECUTION_HEADER = "\n실행 결과";

    @Override
    public void printPositions(Race race) {
        race.getCarsPositions().forEach(this::printPosition);
        printBlankLine();
    }

    @Override
    public void printExecutionHeader() {
        System.out.println(EXECUTION_HEADER);
    }

    @Override
    public void printPosition(Integer position) {
        System.out.println(ONE_POSITION_MARK.repeat(position));
    }

    @Override
    public void printBlankLine() {
        System.out.println();
    }
}
