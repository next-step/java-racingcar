package racingcar.domain;

import racingcar.view.GameOutputView;

public class CarRacing {
    private final Racing racing;
    private final GameOutputView gameOutputView;

    public CarRacing(Racing racing, GameOutputView gameOutputView) {
        this.racing = racing;
        this.gameOutputView = gameOutputView;
    }

    public void race() {
        while(!racing.isFinish()) {
            racing.race(gameOutputView);
        }
    }
}
