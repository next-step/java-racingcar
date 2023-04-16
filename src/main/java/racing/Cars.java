package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carsName) {
        this.cars = addCars(carsName);
    }

    public List<Car> getCars(){
        return cars;
    }

    public List<Car> addCars(String[] carsName){
        return Arrays.stream(carsName)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCarList(List<Car> cars){
        for (Car car : cars) {
            if(RandomNumberGenerator.randomNumber() > 5){
                car.move();
            }
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public List<Car> findWinners(List<Car> cars){
        int maxCarCount = cars.stream()
                .mapToInt(x -> x.getPosition())
                .max()
                .orElseThrow();
        return cars.stream()
                .filter(x -> x.getPosition() == maxCarCount)
                .collect(Collectors.toList());

    }

}
