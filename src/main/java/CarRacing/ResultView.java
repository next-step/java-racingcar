package CarRacing;

public class ResultView {

    public static void lineChange() {
        System.out.println();
    }

    public static void resultPrintResultComment() {
        System.out.println("실행 결과");
    }

    public static void printLine() {
        System.out.print("-");
    }

    public static void printNowCarMoves(int nowCarMoves) {
        for(int j = 0; j< nowCarMoves; j++) {
            ResultView.printLine();
        }
    }
}
