package racing.ui;

import java.util.Objects;

public class ResultView {

    private String board = "";

    public ResultView(String board) {
        this.board = board;
    }

    public void printResult() {
        System.out.println(board);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultView that = (ResultView) o;
        return board.equals(that.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board);
    }
}
