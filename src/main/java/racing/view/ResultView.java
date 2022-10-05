package racing.view;

public class ResultView {
    private static final String DASH = "-";

    public static void init() {
        System.out.println("실행 결과");
    }

    public void result(int distance) {
        if(distance > 0) {
            System.out.print(DASH.repeat(distance));
            System.out.println("");
        }
    }
}
