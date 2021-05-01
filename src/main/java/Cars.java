import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public boolean hasCar(Car car) {
        return cars.contains(car);
    }

    //todo 요구조건에 따라 stream 사용 할 수 없어 수정필요
    public List<Car> getWinningCar(int distance) {
        return cars.stream().filter(car -> car.matchDistance(distance)).collect(Collectors.toList());
    }

    //todo 요구조건에 따라 stream 사용 할 수 없어 수정필요
    public Car getCar(String name) throws NoSuchElementException {
        return cars.stream().filter(car -> car.matchName(name)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    //todo ","쉼표로 나눈 이름으로 Car를 생성하고 Cars에 add한다
    //todo 이름이 조건에(5자 이하의 이름) 맞지 않을 때, 해당 이름을 제외하고 자동차를 생성한다.
    public void setCarsByNames(List<String> names) {
        for (String name : names) {
            Car car = Car.createCar(name);
            cars.add(car);
        }
    }
}
