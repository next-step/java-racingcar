package racingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Round {

    private final List<Integer> positions;

    public Round(List<Integer> positions) {
        this.positions = positions;    }

    public List<Integer> positions() {
        return positions;
    }

    public List<String> drawLines() {
        List<String> lines = new ArrayList<>();

        for (int position : positions) {
            lines.add(draw(position));
        }
        return lines;
    }

    private String draw(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
