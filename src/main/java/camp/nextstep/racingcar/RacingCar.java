package camp.nextstep.racingcar;

public class RacingCar {

    public static final String MOVED_MARK = "-";

    private int numberOfMoves;
    private final MoveCondition condition;

    public RacingCar(MoveCondition condition) {
        this.condition = condition;
    }

    public void move() {
        if (condition.satisfied()) {
            this.numberOfMoves += 1;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < numberOfMoves; i++) {
            result += MOVED_MARK;
        }
        return result;
    }
}
