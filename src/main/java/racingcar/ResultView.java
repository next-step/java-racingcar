package racingcar;

public class ResultView {

    public void showResult(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
