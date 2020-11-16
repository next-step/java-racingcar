package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();


    public Cars(String names){

        String[] nameArr = names.split(",");

        for (String name : nameArr) {
            this.carList.add(new Car(name.trim()));
        }
    }
    public Cars(String[] names){

        for (String name : names) {
            this.carList.add(new Car(name));
        }
    }

    public Cars(List<String> names){
        for(String name : names){
            this.carList.add(new Car(name));
        }
    }


    public Car oneOfCars(int count){
        return this.carList.get(count);
    }

    public int getBestRecord(){
        int bestRecord = 0;
        for(Car car : this.carList) {
            bestRecord = Math.max(car.getLastRecord(),bestRecord);
        }
        return bestRecord;
    }

    public List<String> findWinner(){
        List<String> winners = new ArrayList<>();
        for(Car car : this.carList){
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