package domain;

import service.MoveRule;

public class RacingCar {
    private String name;
    private Integer position;
    private final MoveRule moveRule;

    private RacingCar(String name, Integer position, MoveRule moveRule) {
        this.name = name;
        this.position = position;
        this.moveRule = moveRule;
    }

    public static RacingCar newInstance(String name, MoveRule moveRule) {
        return new RacingCar(name, 0, moveRule);
    }

    public RacingCarPosition move() {
        if (moveRule.isMovable()) {
            position++;
        }
        return new RacingCarPosition(name, position);
    }
}
