package racing;

import java.util.Collection;
import java.util.Random;

public class Round {
    private final Dice dice;
    private boolean finished;

    public Round(Random random) {
        this.dice = new Dice(random);
        this.finished = false;
    }

    void play(Collection<Car> cars) {
        cars.forEach(car -> {
            car.move(dice.roll());
        });
        finished = true;
    }

    boolean isFinished() {
        return finished;
    }

}
