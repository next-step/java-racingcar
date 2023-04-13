package racingcar;

public class RacingResult {

    public void print(int[][] car) {
        for (int i = 0; i < car[0].length; i++) {
            printColumn(car, i);
            System.out.println();
        }
    }

    private void printColumn(int[][] car, int columnIndex) {
        for (int[] row : car) {
            System.out.println("-".repeat(row[columnIndex]));
        }
    }
}
