package racingcar.view;

import java.util.List;

import racingcar.domain.Distance;

public class GameOutputView {
    private final Display displayer;

    public GameOutputView(Display displayer) {
        this.displayer = displayer;
    }

    public void notify(List<Distance> distance) {
        displayer.show(distance);
    }
}


