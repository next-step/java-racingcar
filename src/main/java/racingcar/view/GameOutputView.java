package racingcar.view;

import java.util.List;
import java.util.function.Consumer;

import racingcar.domain.Distance;

public class GameOutputView {
    public Watcher watcher() {
        return new Watcher(new Consumer<List<Distance>>() {
            @Override
            public void accept(List<Distance> distances) {
                for (Distance distance : distances) {
                    System.out.println(distance.toString());
                }
                System.out.println();
            }
        });
    }
}
