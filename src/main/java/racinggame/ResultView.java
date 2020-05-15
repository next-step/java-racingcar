package racinggame;

import java.util.stream.IntStream;

public class ResultView {

    private static final String POSITION_BAR = "-";
    private static final String NEW_LINE = "\n";

    private final ResultCarPositions resultCarPositions;
    private StringBuilder result;
    private String[] prevCarPositions;

    public ResultView(ResultCarPositions resultCarPositions) {
        this.resultCarPositions = resultCarPositions;
        this.result = new StringBuilder();
        this.prevCarPositions = new String[resultCarPositions.getCarCount()];
    }

    public void show() {
        System.out.println("실행 결과");

        IntStream.range(0, this.resultCarPositions.getTotalRound())
                .forEach(round -> recordRoundCarPositions(this.resultCarPositions.getPositions(round)));

        System.out.println(result);
    }

    private void recordRoundCarPositions(int[] roundCarPosition) {
        for (int i = 0; i < roundCarPosition.length; i++) {
            recordCarPosition(i, roundCarPosition[i]);
            addNewLine();
        }
        addNewLine();
    }

    private void recordCarPosition(int carNo, int position) {
        if (position == 0) {
            return;
        }

        String previousPosition = prevCarPositions[carNo];
        if (previousPosition == null) {
            initializeCarPositionBar(carNo);
            return;
        }

        this.result.append(previousPosition);
        addPositionBar(carNo, position, previousPosition);
    }

    private void addPositionBar(int carNo, int position, String previousPosition) {
        if (hasMoved(previousPosition.length(), position)) {
            this.result.append(POSITION_BAR);
            this.prevCarPositions[carNo] += POSITION_BAR;
        }
    }

    private void initializeCarPositionBar(int carNo) {
        this.result.append(POSITION_BAR);
        this.prevCarPositions[carNo] = POSITION_BAR;
    }

    private boolean hasMoved(int previousPosition, int currentPosition) {
        return previousPosition < currentPosition;
    }

    private void addNewLine() {
        this.result.append(NEW_LINE);
    }
}
