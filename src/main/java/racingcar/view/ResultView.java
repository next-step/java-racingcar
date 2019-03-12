package racingcar.view;

public class ResultView {

    public void print(String out) {
        System.out.println(out);
    }

    public void printPosition(int position) {
        for (int dash = 0; dash < position; dash++) {
            System.out.print("-");
        }
        print("");

    }
}