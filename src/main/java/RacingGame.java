import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    public Cars cars;
    public Winner winner;
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

    public void moveAllByCount(int number) {
        for (int i = 0; i < number; i++) {
            this.cars.moveAll();
        }
    }

    public void findWinner() {
        Position position = this.cars.findMaxPosition();
        List<Car> winners = cars.cars.stream()
            .filter(car -> car.position.equals(position))
            .collect(Collectors.toList());
        this.winner = new Winner(winners);
    }
}
