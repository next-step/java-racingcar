package step4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Position {
    private static final int INIT_NUM = 0;
    private static final int MOVE = 1;

    private Map<String, Integer> positions = new HashMap<>();

    public void initPosition(List<String> names) {
        for (int i = 0 ; i < names.size()  ; i++) {
            positions.put(names.get(i), INIT_NUM);
        }
    }

    public void move(String name) {
        positions.put(name, positions.get(name) + MOVE);
    }

    public Map<String, Integer> getPositions() {
        return positions;
    }
}
