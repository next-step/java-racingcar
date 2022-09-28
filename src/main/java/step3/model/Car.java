package step3.model;

public class Car
{
    private String carName;
    private int position;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy)
    {
        validateCarName(carName);
        this.carName = carName;
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
            position++;
        }
    }

    public int getPosition()
    {
        return position;
    }

    public String getCarName()
    {
        return carName;
    }

    private void validateCarName(String carName)
    {
        if (carName.length() > 5)
        {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 엇습니다.");
        }
    }
}
