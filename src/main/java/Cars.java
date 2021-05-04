import java.util.*;

public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public boolean hasCar(Car car) {
        return cars.contains(car);
    }

    public void setCarsByNames(List<String> names) {
        for (String name : names) {
            Car car = Car.createCar(name);
            if(car!=null) cars.add(car);
        }
    }

    private int getMaxDistance(){
        int max = 0;
        for (Car car : cars) {
            max = Integer.max(car.getDistance(), max);
        }
        return max;
    }

    public void setWinningCar() {
        int max = getMaxDistance();
        cars.removeIf(car -> !car.matchDistance(max));
    }

    public List<String> getCarsNames() {
        List<String> carNames = new ArrayList<>();
        cars.forEach(car -> carNames.add(car.getName()));
        return carNames;
    }
}
