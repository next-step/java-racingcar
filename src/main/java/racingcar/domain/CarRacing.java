package racingcar.domain;

public class CarRacing {
    private final Racing racing;
    private final Watcher watcher;

    public CarRacing(Racing racing, Watcher watcher) {
        this.racing = racing;
        this.watcher = watcher;
    }

    public void race() {
        while(!racing.isFinish()) {
            racing.race(watcher);
        }
    }
}
