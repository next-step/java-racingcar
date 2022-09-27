package racingcar.view;

import racingcar.domain.Distance;

public class GameOutputView {
    public Watcher watcher() {
        return new Watcher(distances -> {
            for (Distance distance : distances) {
                System.out.println(distance);
            }
            System.out.println();
        });
    }
}
