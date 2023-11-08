package racingCar;

public class resultView {
    public static void printResult(int[] cars) {
        for (int car : cars) {
            for (int j = 0; j < car; j++) {
                System.out.print('-');
            }
        }
    }
}
