package racing.domain;

import racing.domain.model.CarName;
import racing.domain.model.Position;

public class Car
{
    private CarName carName;
    private Position position;
    private final MovingStrategy movingStrategy;

    private Car(CarName carName, MovingStrategy movingStrategy)
    {
        this.carName = carName;
        this.position = Position.newPosition(0);
        this.movingStrategy = movingStrategy;
    }

    private Car(MovingStrategy movingStrategy)
    {
        this.movingStrategy = movingStrategy;
    }

    public static Car newCar(CarName carName, MovingStrategy movingStrategy)
    {
        return new Car(carName, movingStrategy);
    }

    public static Car newCar(MovingStrategy movingStrategy)
    {
        return new Car(movingStrategy);
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
}
