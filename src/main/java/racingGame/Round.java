package racingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Round {

    private final List<Integer> positions;

    public Round(List<Integer> positions) {
        this.positions = new ArrayList<>(positions);
    }

    public List<Integer> positions() {
        return Collections.unmodifiableList(positions);
    }

    public List<String> drawLines() {
        List<String> lines = new ArrayList<>();

        for (int position : positions) {
            lines.add(draw(position));
        }
        return lines;
    }

    private String draw(int position) {
        int safe = Math.max(0, position);
        return "-".repeat(safe);
    }
}
