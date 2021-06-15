package domain;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

    List<Car> carList;
    int playCount;

    public RacingGame(String carNames, int playCount) {
        carList = new ArrayList<>();
        for(String car : carNames.split(",")){
            carList.add(new Car(car.trim()));
        }
        this.playCount = playCount;
    }

    public boolean isEnd() {
        return this.playCount == 0;
    }

    public void race() {
        for(Car car : carList){
            car.moveOrNot();
        }
        playCount--;
    }

    public List<Car> getCars() {
        return carList;
    }

    public String getWinners() {
        List<String> winners = new ArrayList<>();
        Map<String, Integer> carMap = carList.stream().collect(Collectors.toMap(Car::getCarName, Car::getPosition));
        int MaxPosition = Collections.max(carMap.values());

        for(String car : carMap.keySet()){
            if(carMap.get(car) == MaxPosition){
                winners.add(car);
            }
        }

        return winners.toString();
    }
}
