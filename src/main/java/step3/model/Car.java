package step3.model;

public class Car
{
    private int position;
    private final MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy)
    {
        this.movingStrategy = movingStrategy;
    }

    public Car moving()
    {
        if (movingStrategy.movable())
        {
            position++;
        }
        return this;
    }

    public int getPosition()
    {
        return position;
    }
}
