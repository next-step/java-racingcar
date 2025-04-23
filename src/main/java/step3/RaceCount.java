package step3;

import java.util.List;
import java.util.function.Supplier;

public class RaceCount {
    private int count;

    public RaceCount(int count) {
        this.count = count;
    }

    public List<Position> play(Supplier<List<Position>> action) {
        if (isDone()) {
            throw new RuntimeException("게임을 완료하였습니다.");
        }

        count--;
        return action.get();
    }

    public boolean isDone() {
        return count <= 0;
    }
}
