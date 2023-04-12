package racingcar;

public class RacingResult {

    RacingResult(int[][] car) {
        for (int[] row : car) {
            for (int length : row) {
                System.out.print("-".repeat(length));
                System.out.println();
            }
            System.out.println();
        }
    }
}
