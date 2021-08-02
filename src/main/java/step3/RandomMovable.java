package step3;

import java.util.List;

public class RandomMovable implements Movable {
    @Override
    public void move(List<String> status) {
        if (RandomMoveDeterminator.doMoving()) go(status);
    }

    private void go(List<String> status) {
        status.add("-");
    }
}
