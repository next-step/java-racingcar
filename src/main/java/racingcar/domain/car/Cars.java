package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }
    public static Cars of(List<Car> cars)
    {
        return new Cars(cars);
    }
    public static Cars of(String names){
        String[] nameArr = names.split(",");
        return of(nameArr);
    }
    public static Cars of(String[] nameArr){
        List<Car> cars = new ArrayList<>();
        for(String name : nameArr){
            cars.add(new Car(name.trim()));
        }
        return of(cars);
    }
    public int getPlayerNumber(){
        return cars.size();
    }

    public Car oneOfCars(int count){
        return cars.get(count);
    }

    public int getBestRecord(){
        int bestRecord = 0;
        for(Car car : cars) {
            bestRecord = Math.max(car.getLastRecord(),bestRecord);
        }
        return bestRecord;
    }

    public List<String> findWinner(){
        List<String> winners = new ArrayList<>();
        for(Car car : cars){
            isWinner(winners, car);
        }
        return winners;
    }

    public void isWinner(List<String> winners, Car car){
        if(car.getLastRecord() == getBestRecord()){
            winners.add(car.getName());
        }
    }



}