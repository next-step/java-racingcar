package domain;

import service.MoveRule;

public class RacingCar {
    private final RacingCarName name;
    private Integer position;
    private final MoveRule moveRule;

    private RacingCar(RacingCarName name, Integer position, MoveRule moveRule) {
        this.name = name;
        this.position = position;
        this.moveRule = moveRule;
    }

    public static RacingCar newInstance(RacingCarName name, MoveRule moveRule) {
        return new RacingCar(name, 0, moveRule);
    }

    public static RacingCar newInstance(String name, MoveRule moveRule) {
        return newInstance(RacingCarName.newInstance(name), moveRule);
    }

    public RacingCarPosition move() {
        if (moveRule.isMovable()) {
            position++;
        }
        return RacingCarPosition.newInstance(name, position);
    }
}
