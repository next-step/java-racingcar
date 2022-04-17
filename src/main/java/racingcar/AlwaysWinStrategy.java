package racingcar;

public class AlwaysWinStrategy implements RollStrategy {
    public RolledResult roll(Car car) {
        car.move();
        return new RolledResult(true, car);
    }
}
