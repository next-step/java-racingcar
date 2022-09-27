package step3;

public class ResultView {
    private static final String DASH = "-";

    public void init() {
        System.out.println("실행 결과");
    }

    public void result(int distance) {
        System.out.print(DASH.repeat(distance));
        System.out.println("");
    }
}
