import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {
    private List<Car> cars;

    public static RacingCars of(int numberOfCar) {
        if(numberOfCar < 0){
            throw new IllegalArgumentException();
        }

        List<Car> cars = IntStream.range(0, numberOfCar)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());

        return new RacingCars(cars);
    }

    private RacingCars(List<Car> racingCars) {
        this.cars = racingCars;
    }

    public List<Car> getCars(){
        return cars;
    }


}
