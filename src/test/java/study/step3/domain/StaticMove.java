package study.step3.domain;

public class StaticMove implements MoveStrategy {
    private int distance;

    public StaticMove(int distance) {
        this.distance = distance;
    }

    @Override
    public int createMove() {
        return distance;
    }
}
