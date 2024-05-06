import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final Cars cars;
    private final MovePolicy movePolicy;

    public RacingCar(MovePolicy movePolicy, String names) {
        this.movePolicy = movePolicy;
        this.cars = new Cars(createCarList(names));
    }

    private List<Car> createCarList(String names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names.split(",")) {
            carList.add(new Car(name));
        }

        return carList;
    }

    public Cars start(MovePolicy movePolicy, int numberOfTry) {
        for (int i = 0; i < numberOfTry; i++) {
            cars.move(movePolicy);
        }

        return cars;
    }

    public List<Car> getWinners() {
        return this.cars.findWinners();
    }

    public int getCarCount() {
        return this.cars.getCount();
    }
}
