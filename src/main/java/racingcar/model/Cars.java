package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private List<Car> cars;

    public static Cars generate(int count){
        List<Car> cars = IntStream.range(0, count)
                            .mapToObj(value -> new Car())
                            .collect(Collectors.toList());
        return new Cars(cars);
    }

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    List<Car> init(){
        for (Car car : cars) {
            car.move();
        }
        return getCars();
    }

    List<Car> moveAll(Mover mover){
        for (Car car : cars) {
            move(mover, car);
        }
        return getCars();
    }

    boolean move(Mover mover, Car car) {
        return mover.move(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return "Cars{" + "cars=" + cars + '}';
    }
}
