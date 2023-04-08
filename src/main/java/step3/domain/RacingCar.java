package step3.domain;

import step3.strategy.draw.DrawStrategy;
import step3.strategy.move.MoveStrategy;

public class RacingCar {

    private final MoveStrategy moveStrategy;
    private final DrawStrategy drawStrategy;
    private final Position position;

    private RacingCar(
            MoveStrategy moveStrategy
            , Position position
            , DrawStrategy drawStrategy
    ) {

        this.moveStrategy = moveStrategy;
        this.position = position;
        this.drawStrategy = drawStrategy;
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            position.increase();
        }
    }

    public static RacingCar of(
            MoveStrategy moveStrategy
            , Position position
            , DrawStrategy drawStrategy
    ) {
        return new RacingCar(moveStrategy, position, drawStrategy);
    }

    public Position getPosition() {
        return position;
    }

    public String getCurrentLocation() {
        return drawStrategy.draw(position);
    }


}
