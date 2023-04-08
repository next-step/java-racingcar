package racingcar;

public class ResultView {

    static void printResult(int[] cars) {
        for (int i = 0; i < cars.length; i++) {
            for (int j = 0; j < cars[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println("################################################################");
    }
}
