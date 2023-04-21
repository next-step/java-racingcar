package carrace;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private List<Integer> positions; // round별 위치

    public Car() {
        this.positions = new ArrayList<>();
    }

    public void setNewRoundPosition(int position) {
        this.positions.add(position);
    }

    public int getRecentRoundPosition() {
        if (this.positions.size() == 0) {
            return 0;
        }
        return this.positions.get(this.positions.size() - 1);
    }

    public int getPositionAtRound(int round) {
        if (round < 0 || this.positions.size() < round) {
            throw new IndexOutOfBoundsException();
        }
        return this.positions.get(round);
    }
}
