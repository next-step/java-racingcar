package carRacing.car;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars){
        this.cars = cars;
    }

    public static Cars of(List<Car> cars){
        return new Cars(cars);
    }

    public void addCar(Car car) throws IllegalAccessException {
        if(isNameDuplicated(car.getName())){
            throw new IllegalAccessException("이미 존재하는 이름입니다.");
        }
        cars.add(car);
    }

    public List<String> getWinners(){
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(){
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);
    }

    public void forEach(Consumer<Car> action) {
        cars.forEach(action);
    }

    private boolean isNameDuplicated(String name){
        return cars.stream()
                .anyMatch(car -> car.getName().equals(name));
    }

}
