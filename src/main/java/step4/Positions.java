package step4;

import java.util.ArrayList;
import java.util.List;

public class Positions {
    private static final int INIT_NUM = 0;
    private static final int MOVE = 1;

    private List<Integer> positions = new ArrayList<>();

    public void initPositions(int cars) {
        for (int i = 0 ; i < cars ; i++) {
            positions.add(INIT_NUM);
        }
    }

    public void move(int index) {
        positions.add(index, positions.get(index) + MOVE);
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
