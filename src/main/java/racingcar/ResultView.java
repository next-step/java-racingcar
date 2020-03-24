package racingcar;

import java.util.List;
import java.util.Map;

public class ResultView {

    private Map<Integer, List<Integer>> record;
    private int tryCount;

    public ResultView(Map<Integer, List<Integer>> record) {
        this.record = record;
        tryCount = record.size();
    }

    public void show() {
        System.out.println("실행결과");

        for (int count = 1; count <= this.tryCount; count++) {
            showCarPositions(record.get(count));
            System.out.println();
        }
    }

    private void showCarPositions(List<Integer> positions) {
        for (Object position : positions) {
            showGraph((Integer) position);
        }
    }

    private void showGraph(int position) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < position; j++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }
}
