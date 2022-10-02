package racing.domain;

import racing.domain.model.CarName;
import racing.domain.strategy.MovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars
{
    private final List<Car> carList;

    private Cars(List<Car> carList)
    {
        this.carList = carList;
    }


    public static Cars of(String[] carNames, MovingStrategy movingStrategy)
    {
        return new Cars(Arrays.stream(carNames)
            .map(carName -> new Car(CarName.from(carName), movingStrategy))
            .collect(Collectors.toList()));
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
