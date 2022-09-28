package step3.model;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cars
{
    private final List<Car> carList;

    public Cars(int number, MovingStrategy movingStrategy)
    {
        this.carList = new ArrayList<>();

        IntStream.range(0, number)
            .forEach(value -> carList.add(new Car(movingStrategy)));
    }

    public List<Car> getCarList()
    {
        return carList;
    }

    public List<Car> moving()
    {
        carList.forEach(Car::moveForward);

        return carList;
    }
}
