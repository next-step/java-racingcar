package racingcar;

public class ResultView {

    public void displayResults(int[][] carPositions) {
        int trialCount = carPositions[0].length;
        for (int i = 0; i < trialCount; i++) {
            displayColumn(carPositions, i);
            System.out.println();
        }
    }

    private void displayColumn(int[][] carPositions, int columnIndex) {
        for (int[] positions : carPositions) {
            System.out.println("-".repeat(positions[columnIndex]));
        }
    }
}
