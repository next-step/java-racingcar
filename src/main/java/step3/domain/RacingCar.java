package step3.domain;

import step3.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class RacingCar {

    public static final int RANDOM_LIMIT = 10;
    public static final int LIMIT = 4;

    public static List<Car> createCars(String[] names){
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<names.length; i++){
            cars.add(new Car(names[i]));
        }
        return cars;
    }

    public String[] split(String carsName) {
        String[] names = Stream.of(carsName.split(",")).map(String::trim).toArray(String[]::new);
        return names;
    }

    public void oneRace(List<Car> cars) {
        for (Car car : cars) {
            goOrStop(car);
        }
    }

    public void goOrStop(Car car) {
        boolean isGo = isValueMoreThan(randomValue());
        if(isGo){
            car.addGoCount();
        }
    }

    public boolean isValueMoreThan(int value) {
        return value >= LIMIT;
    }

    private int randomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_LIMIT);
    }

}
