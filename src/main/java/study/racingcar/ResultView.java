package study.racingcar;

public class ResultView {

    private static final String MOVE_MARK = "-";
    public static void resultGame(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print(MOVE_MARK);
        }
        emptyLine();
    }

    public static void emptyLine() {
        System.out.println();
    }

    public static void startGame() {
        System.out.println("실행 결과");
    }
}
