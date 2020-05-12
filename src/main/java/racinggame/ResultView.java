package racinggame;

import java.util.List;

public class ResultView {

    private static final String POSITION_BAR = "-";
    private static final String NEW_LINE = "\n";

    private List<int[]> roundCarPositions;
    private StringBuilder result;
    private String[] prevCarPositions;

    public ResultView(List<int[]> roundCarPositions) {
        validateResultPositions(roundCarPositions);

        this.roundCarPositions = roundCarPositions;
        this.result = new StringBuilder();
        this.prevCarPositions = new String[roundCarPositions.get(0).length];
    }

    private void validateResultPositions(List<int[]> roundCarPositions) {
        if (roundCarPositions == null) {
            throw new IllegalArgumentException("결과 집합이 존재해야 합니다.");
        }

        if (roundCarPositions.size() == 0) {
            throw new IllegalArgumentException("결과 횟수가 한 건 이상 존재해야 합니다.");
        }
    }

    public void showResult() {
        System.out.println("실행 결과");

        this.roundCarPositions.forEach(this::recordRoundCarPositions);

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
        if (initializeCarPositionBar(carNo, previousPosition)) {
            return;
        }

        result.append(previousPosition);
        addPositionBar(carNo, position, previousPosition);
    }

    private void addPositionBar(int carNo, int position, String previousPosition) {
        if (hasMoved(previousPosition.length(), position)) {
            result.append(POSITION_BAR);
            prevCarPositions[carNo] += POSITION_BAR;
        }
    }

    private boolean initializeCarPositionBar(int carNo, String previousPosition) {
        if (previousPosition != null) {
            return false;
        }

        result.append(POSITION_BAR);
        prevCarPositions[carNo] = POSITION_BAR;
        return true;
    }

    private boolean hasMoved(int previousPosition, int currentPosition) {
        return previousPosition < currentPosition;
    }

    private void addNewLine() {
        result.append(NEW_LINE);
    }
}
