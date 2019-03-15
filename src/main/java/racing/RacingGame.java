package racing;

import java.util.*;

public class RacingGame {

    private final static int RANDOM_VALUE_MAX = 10;
    List<Car> cars = null;

    public static int generateRandomValue() { return new Random().nextInt(RANDOM_VALUE_MAX); }

    public List<Car> race() {
        for (Car car:cars) { car.move(generateRandomValue()); }
        return cars;
    }

    public RacingGame(int numberOfCar) {
        this.cars = new ArrayList<Car>(numberOfCar);
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(i, new Car(0));
        }
    }

    public RacingGame(String[] namesOfCars) {
        int numberOfCar = namesOfCars.length;
        this.cars = new ArrayList<Car>(numberOfCar);
        for(String name:namesOfCars) {
            cars.add(new Car(name));
        }
    }

    //TODO : 최종 우승했습니다 구현
    public List<Car> getWinner(List<Car> cars) {
        int maxCarPosition = cars.get(0).getPosition();

        for(Car car:cars){
            maxCarPosition = (car.getPosition() > maxCarPosition) ? car.getPosition() : maxCarPosition;
        }

        List<Car> winners = new ArrayList<Car>();
        for(Car car:cars){
            if(car.getPosition() == maxCarPosition) { winners.add(car); }
        }
        return winners;
    }

}
