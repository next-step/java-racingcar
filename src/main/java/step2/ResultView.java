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
            System.out.println(Arrays.toString(ints));
        }
    }
}
