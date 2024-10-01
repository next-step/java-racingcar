package carracing;

public class ResultView {

    public static void lineChange() {
        System.out.println();
    }

    public static void resultPrintResultComment() {
        System.out.println("실행 결과");
    }

    public static String printNowCarMoves(int nowCarMoves) {
        return "-".repeat(nowCarMoves);
    }
}
