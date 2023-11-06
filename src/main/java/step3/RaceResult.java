package step3;

import java.util.Arrays;

public class RaceResult {

    private final String[] board;

    public RaceResult(String[] board) {
        this.board = board;
    }

    public void show() {
        System.out.println(Arrays.toString(this.board));
    }
}
