package model;

public class AlwaysMoveStrategy implements MoveStrategy{
    @Override
    public int nextPosition(Car car) {
        return car.getPosition() + 1;
    }
}
