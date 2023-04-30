import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(int totalOfCars) {
        for (int index = 0; index < totalOfCars; index++) {
            Car car = cars.get(index);
            car.move(RandomGenerator.create());
        }
    }

    public List<Car> showCars() {
        return cars;
    }
}
