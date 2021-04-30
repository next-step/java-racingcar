import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars;

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
        return cars.stream().filter(car -> car.distance == distance).collect(Collectors.toList());
    }
}
