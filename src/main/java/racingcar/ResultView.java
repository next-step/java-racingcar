package racingcar;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static final String DASH = "-";
    private Map<Integer, List<Integer>> record;

    public ResultView(Map<Integer, List<Integer>> record) {
        this.record = record;
    }

    public void show() {
        System.out.println("실행결과");

        for (int count = 1; count <= record.size(); count++) {
            showCarPositions(record.get(count));
            System.out.println();
        }
    }

    public String showGraph(int position) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < position; j++) {
            sb.append(DASH);
        }
        return sb.toString();
    }

    private void showCarPositions(List<Integer> positions) {
        positions.stream()
                .map(this::showGraph)
                .forEach(System.out::println);
    }


}
