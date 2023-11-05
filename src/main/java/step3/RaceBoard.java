package step3;

import java.util.Arrays;

public class RaceBoard {

    public static String[] generate(int cars) {
        String[] board = new String[cars];

        Arrays.fill(board, "-");
        return board;
    }
}
