package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

    private List<Car> cars;

    private Random random;

    public Race(Random random) {
        this.cars = new ArrayList<>();
        this.random = random;
    }

    public List<Car> getCars(){
        return this.cars;
    }

    public void createCars(int carCount){
        for(int i = 0 ; i < carCount ; i++){
            this.cars.add(new Car(random));
        }
    }

    public void round(){
        for(Car car : this.cars){
            car.run();
        }
    }
}
