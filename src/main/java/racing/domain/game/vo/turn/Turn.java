package racing.domain.game.vo.turn;

import racing.domain.car.vo.Location;

public class Turn {
    private boolean waiting;

    public Turn() {
        waiting = true;
    }

    public void finish() {
        waiting = false;
    }

    public boolean isWaiting() {
        return waiting;
    }
}
