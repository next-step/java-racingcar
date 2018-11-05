package racinggame;

public class ResultView {

    public static void resultRacing(int[] carPosition) {
        for(int i = 0; i < carPosition.length; i++) {
            printDash(carPosition[i]);
        }
        System.out.println();

    }

    public static void printDash(int carPosition) {
        for(int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
