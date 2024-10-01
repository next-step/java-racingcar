package racingcar.basic.view;

public class ResultView {

    private ResultView() {
    }

    public static void showCarStatus(int position) {
        StringBuilder status = new StringBuilder();
        for (int cnt = 0; cnt < position; ++cnt) {
            status.append("-");
        }
        System.out.println(status);
    }

    public static void showResultDescription() {
        System.out.println("실행 결과");
    }

    public static void nextLine() {
        System.out.println();
    }
}
