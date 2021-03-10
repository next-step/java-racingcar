import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private GameCondition gameCondition;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setMoveStrategy(GameCondition gameCondition){
        this.gameCondition = gameCondition;
    }

    public List<Integer> getCarRecords() {
        return cars.stream()
                .map(Car::getNumberOfAdvance)
                .collect(Collectors.toList());
    }

    public void advanceCars() {
        cars.forEach(car -> car.advance(gameCondition));
    }
}
