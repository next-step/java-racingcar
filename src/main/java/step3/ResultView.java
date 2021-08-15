package step3;

public class ResultView {

    private final String GAME_RESULT = "실행결과";
    private final String DASH = "-";

    public void printGameResult(int result) {

        for(int i = 0; i < result; i++) {
            System.out.print(DASH);
        }

        System.out.println();
    }

    public void printGameResultText() {
        System.out.println(GAME_RESULT);
    }

    public void printNewLine() {
        System.out.println();
    }
}
