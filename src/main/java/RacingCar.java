import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final Cars cars;

    public RacingCar(String names) {
        this.cars = new Cars(createCarList(names));
    }

    private List<Car> createCarList(String names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names.split(",")) {
            carList.add(new Car(name));
        }

        return carList;
    }

    public Cars move(MovePolicy movePolicy) {
        cars.move(movePolicy);

        return cars;
    }

    public List<Car> getWinners() {
        return this.cars.findWinners();
    }

    public int getCarCount() {
        return this.cars.getCount();
    }
}
