package racingcar.domain;

public class Cycle {
    private int cycle;

    public Cycle(int cycle) {
        this.cycle = cycle;
    }

    public void minusCycle() {
        this.cycle--;
    }

    public boolean isEnd() {
        return cycle == 0;
    }
}
