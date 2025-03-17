package racing;

import java.util.Collection;
import java.util.Random;

public class Round {
    private final Dice dice;
    private boolean finished;

    public Round(Dice dice) {
        this.dice = dice;
        this.finished = false;
    }

    void play(Collection<Car> cars) {
        if (finished) {
            throw new IllegalStateException("이미 종료된 라운드입니다.");
        }

        cars.forEach(car -> {
            car.move(dice.roll());
        });
        finished = true;
    }

    boolean isFinished() {
        return finished;
    }

}
