package step3.view;

public class OutputView {

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printCarDistance(Integer distance) {
        System.out.println("-".repeat(distance));
    }

    public static void endOfThisTurn() {
        System.out.println();
    }
}
