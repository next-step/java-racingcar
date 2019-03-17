package racinggame.DTO;

import racinggame.domain.Car;

public class WebGame {
    String player;
    String moveDistance;

    public WebGame(Car car, String moveDistance) {
        this.player = car.getName();
        this.moveDistance = moveDistance;
    }

    public String getPlayer() {
        return player;
    }

    public String getMoveDistance() {
        return moveDistance;
    }
}
