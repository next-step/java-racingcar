package domain;

import service.MoveRule;

import static utils.RacingCarUtils.validateCarName;

public class RacingCar {
    private final String name;
    private Integer position;
    private final MoveRule moveRule;

    private RacingCar(String name, Integer position, MoveRule moveRule) {
        this.name = name;
        this.position = position;
        this.moveRule = moveRule;
    }

    public static RacingCar newInstance(String name, MoveRule moveRule) {
        validateCarName(name);
        return new RacingCar(name, 0, moveRule);
    }

    public RacingCarPosition move() {
        if (moveRule.isMovable()) {
            position++;
        }
        return RacingCarPosition.newInstance(name, position);
    }
}
