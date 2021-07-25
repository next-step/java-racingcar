package racing.domain.game.vo.turn;

import racing.domain.car.entity.Cars;

public class Turn {
    private boolean waiting;
    private Cars snapshot;

    public Turn() {
        waiting = true;
    }

    public void finish(Cars cars) {
        this.waiting = false;
        captureSnapshot(cars);
    }

    private void captureSnapshot(Cars cars) {
        this.snapshot = (Cars) cars.clone();
    }

    public Cars snapshot() {
        return snapshot;
    }

    public boolean isWaiting() {
        return waiting;
    }
}
