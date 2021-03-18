package step4.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(String[] carNames){
        cars = new ArrayList<>();
        for(int i = 0; i < carNames.length; i++){
            Car car = new Car(carNames[i]);
            cars.add(car);
        }
    }

    public void move(MoveStrategy moveStrategy){
        for(Car car : cars){
            car.move(moveStrategy);
        }
    }

    public Car getCar(int i){
        return cars.get(i);
    }

    public int getNumberOfCars(){
        return cars.size();
    }

    public Winners Winners(){
        Distance farthestDistance = farthestDistance();
        return new Winners(cars.stream()
                        .filter(car -> car.isWinner(farthestDistance))
                        .collect(Collectors.toList()));
    }

    Distance farthestDistance(){
        Distance farthestDistance = new Distance();
        for (Car car : cars) {
            farthestDistance = car.max(farthestDistance);
        }
        return farthestDistance;
    }

    public Iterable<Car> cars() {
        return Collections.unmodifiableList(this.cars);
    }

}
