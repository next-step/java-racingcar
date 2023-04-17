package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

    private final int raceCount;
    private final List<Car> cars;
    private final static Random random = new Random();

    private Race(int raceCount, List<Car> cars) {
        this.raceCount = raceCount;
        this.cars = cars;
    }

    public static Race from(int raceCount, int carCount){
        List<Car> cars = new ArrayList<>(carCount);
        for(int i = 0; i < carCount; i++){
            cars.add(new Car());
        }

        return new Race(raceCount, cars);
    }

    public int getRaceCount() {
        return raceCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race(){
        for(int i = 0; i < raceCount; i++){
            raceCar();
        }
    }

    private void raceCar(){
        cars.stream()
                .filter(car -> success())
                .forEach(Car::move);
    }

    private boolean success(){
        int randomNumber = random.nextInt(10);
        if(randomNumber < 4) {
            return false;
        }
        return true;
    }
}
