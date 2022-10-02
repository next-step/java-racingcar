package racing.domain;

import racing.domain.model.CarName;
import racing.domain.model.Position;
import racing.domain.strategy.MovingStrategy;

public class Car
{
    private CarName carName;
    private Position position;
    private final MovingStrategy movingStrategy;

    public Car(CarName carName, MovingStrategy movingStrategy)
    {
        this.carName = carName;
        this.position = Position.of(0);
        this.movingStrategy = movingStrategy;
    }

    public Car(MovingStrategy movingStrategy)
    {
        this.movingStrategy = movingStrategy;
    }

    public void moveForward()
    {
        if (movingStrategy.movable())
        {
            position.increase();
        }
    }

    public int getPosition()
    {
        return position.getPosition();
    }

    public String getCarName()
    {
        return carName.getCarName();
    }

    public boolean isWinner(int winnerPosition)
    {
        return position.getPosition() == winnerPosition;
    }
}
