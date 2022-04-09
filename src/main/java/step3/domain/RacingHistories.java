package step3.domain;

import java.util.LinkedList;
import java.util.List;

public class RacingHistories {

    List<String> histories = new LinkedList<>();

    public void add(Cars cars) {
        StringBuilder sb = new StringBuilder();
        List<Integer> positions = cars.getPositions();
        for (Integer position : positions) {
            sb.append(printPosition(position));
            sb.append("\n");
        }

        histories.add(sb.toString());
    }

    private String printPosition(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; ++i) {
            sb.append('-');
        }
        return sb.toString();
    }

    public List<String> getHistories() {
        return histories;
    }

}
