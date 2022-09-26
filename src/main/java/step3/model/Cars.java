package step3.model;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Cars
{
    private final List<Car> carList;
    private final int tryNumber;

    public Cars(int number, int tryNumber)
    {
        this.carList = new ArrayList<>();
        this.tryNumber = tryNumber;

        IntStream.range(0, number)
            .forEach(value -> carList.add(new Car(new RandomMove())));
    }

    public Stream<Car> stream()
    {
        return carList.stream();
    }

    public int getTryNumber()
    {
        return tryNumber;
    }
}
