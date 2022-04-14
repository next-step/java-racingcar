package racingcar;

public class OutputView {

    private OutputView() {
    }

    public static void printRound(int speed, int distance) {
        System.out.print("speed = " + speed + ": ");
        for (int j = 0; j < distance; j++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
