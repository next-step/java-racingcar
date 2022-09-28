package step3.model;

public class Car
{
    private int position;
    private final MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy)
    {
        this.movingStrategy = movingStrategy;
    }

    public void moveForward()
    {
        if (movingStrategy.movable())
        {
            position++;
        }
    }

    public int getPosition()
    {
        return position;
    }
}
