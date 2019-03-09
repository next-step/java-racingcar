package racingcar;

public class RacingGameStatusViewer {

    static void showRacingGameStatus(int[] carPosition) {
        int cars = carPosition.length;

        for (int car=0; car<cars; car++) {
            int position = carPosition[car];
            printStatus(position);
        }
        System.out.println();
    }

    private static void printStatus(int position) {
        for(int p=0; p<=position ; p++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
