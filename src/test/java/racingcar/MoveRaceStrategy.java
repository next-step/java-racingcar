package racingcar;

public class MoveRaceStrategy implements RaceStrategy{
    @Override
    public void move(Car car) {
        car.move();
    }
}
