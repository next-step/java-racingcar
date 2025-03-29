import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    public Cars cars;
    private final Random random = new Random();

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public RacingGame(String[] name) {
        List<Car> carList = Arrays.stream(name)
            .map(Car::new)
            .collect(Collectors.toList());
        this.cars = new Cars(carList);
    }

    public void move() {
        this.cars.moveAll();
    }
}
