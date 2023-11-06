package step3;

import java.util.Arrays;

public class RaceBoard {

    private final int cars;

    public RaceBoard(int cars) {
        this.cars = cars;
    }

    public String[] generate() {
        String[] board = new String[this.cars];

        Arrays.fill(board, "-");
        return board;
    }
}
