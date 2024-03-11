package racingcar.domain;

public class CustomCarMoveCondition implements CarMoveCondition {

    private final String status;

    public CustomCarMoveCondition(String status) {
        this.status = status;
    }

    @Override
    public boolean movable() {
        return this.status.equals("MOVE");
    }
}
