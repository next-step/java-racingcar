package step4.model;

import java.util.ArrayList;
import java.util.List;

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
        for(int i = 0; i < cars.size(); i++){
            cars.get(i).move(moveStrategy);
        }
    }

    public Car getCar(int i){
        return cars.get(i);
    }

    public int getNumberOfCars(){
        return cars.size();
    }

    public String[] getWinners(){
        int farthestDistance = getFarthestDistance();
        return cars.stream()
                .filter(car -> car.getDistance() == farthestDistance)
                .map(car -> car.getName())
                .toArray(String[]::new);
    }

    int getFarthestDistance(){
        return cars.stream()
                .sorted()
                .findFirst()
                .get()
                .getDistance();
    }

}
