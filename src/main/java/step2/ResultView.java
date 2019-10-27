package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultView {
    private List<int[]> results;

    public ResultView() {
        this.results = new ArrayList<>();
    }

    public void addResult(int[] result) {
        results.add(result);
    }

    public void printResultView() {
        for (int[] ints : results) {
            carPositionView(ints);
            System.out.println();
        }
    }

    public void carPositionView(int[] carPositions) {
        for (int i = 0; i < carPositions.length; i++) {
            printBar(carPositions[i]);
        }
    }

    public void printBar(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("- ");
        }
        System.out.println();
    }
}
