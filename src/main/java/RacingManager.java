import java.util.List;

public class RacingManager {
    private final List<Car> cars;

    public RacingManager(List<Car> cars) {
        this.cars = cars;
    }

    public int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public void play() {
        this.cars.forEach(car -> car.moveOneBy(getRandomNumber()));
    }
}
