package carrace;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private List<Integer> position; // round별 위치

    public Car() {
        this.position = new ArrayList<>();
    }

    public void setNewRoundPosition(int position) {
        this.position.add(position);
    }

    public int getRecentRoundPosition() {
        if (this.position.size() == 0) {
            return 0;
        }
        return this.position.get(this.position.size() - 1);
    }

    public int getPositionAtRound(int round) {
        if (round < 0 || this.position.size() < round) {
            throw new IndexOutOfBoundsException();
        }
        return this.position.get(round);
    }
}
