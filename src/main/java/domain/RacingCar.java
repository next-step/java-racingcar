package domain;

import service.MoveRule;

public class RacingCar {

    private Integer position;
    private final MoveRule moveRule;

    private RacingCar(Integer position, MoveRule moveRule) {
        this.position = position;
        this.moveRule = moveRule;
    }

    public static RacingCar newInstance(MoveRule moveRule) {
        return new RacingCar(0, moveRule);
    }

    public void move() {
        if (moveRule.isMovable()) {
            position++;
        }
    }

    public Integer getPosition() {
        return position;
    }
}
