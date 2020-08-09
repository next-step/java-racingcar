package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cars {
    private List<Car> cars;

    public Cars(int carCount) {
        makeCars(carCount);
    }

    public Stream<Car> stream(){
        return cars.stream();
    }

    public void makeCars(int carCount) {
        cars = new ArrayList<>();
        for(int i = 0; i< carCount; i++){
            cars.add(new Car());
        }
    }

    public void moveCars(){
        for(Car car : cars){
            int random = RacingGame.randomNumber();
            car.move(random);
        }
    }
}
