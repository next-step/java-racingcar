package study.racing.ui;

import java.util.Arrays;

public class ResultView {
    private static final char CAR_MOVED = '-';

    public void printCarPositions(int[] carPositions) {
        for(Integer i : carPositions) {
            char[] chars = new char[i];
            Arrays.fill(chars, CAR_MOVED);

            System.out.println(chars);
        }

        System.out.println();
    }


}
