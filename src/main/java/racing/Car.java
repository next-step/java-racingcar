package racing;

import static racing.Judgement.isNumberGreaterThanFour;
import static racing.RandomUtil.randomNumberZeroToNine;

public class Car {

    private final Position position;

    public Car() {
        this.position = new Position();
    }

    public void forward() {
        position.add(1);
    }

    public boolean hasPosition(int value) {
        return position.equals(new Position(value));
    }

    public String carPosition() {
        return position.dashOfPosition();
    }

    public void play() {
        if (isNumberGreaterThanFour(randomNumberZeroToNine())) {
            forward();
        }
    }
}
