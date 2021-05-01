import java.util.*;
import java.util.stream.Collectors;

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

    //todo 요구조건에 따라 stream 사용 할 수 없어 수정필요
    //todo List를 그대로 반환해도 되는걸까?
    public List<Car> getWinningCar(int distance) {
        return cars.stream().filter(car -> car.matchDistance(distance)).collect(Collectors.toList());
    }

    //todo 요구조건에 따라 stream 사용 할 수 없어 수정필요
    public List<String> getCarsNames(List<Car> cars) {
        return cars.stream().map(car -> car.getName()).collect(Collectors.toList());
    }

    //todo 요구조건에 따라 stream 사용 할 수 없어 수정필요
    public Car getCar(String name) throws NoSuchElementException {
        return cars.stream().filter(car -> car.matchName(name)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    public void setCarsByNames(List<String> names) {
        for (String name : names) {
            Car car = Car.createCar(name);
            cars.add(car);
        }
    }
}
