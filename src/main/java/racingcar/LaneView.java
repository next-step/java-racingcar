package racingcar;

public class LaneView {
    private final int position;

    public LaneView(int position) {
        this.position = position;
    }

    void print() {
        for (int i = 0; i < position; i++) {
            ResultView.print("-");
        }
        ResultView.println();
    }
}
