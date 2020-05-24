package racingcar.racinggame;

import racingcar.car.Car;
import racingcar.common.RandomHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RacingGame {
    public final static int DEFAULT_RANDOM_RANGE = 10;
    private List<Car> carList;
    private int gameCount;
    private int playCount;

    public RacingGame() {
        this.carList = new ArrayList<>();
        playCount = 0;
        gameCount = 0;
    }

    public boolean makeCar(String[] nameArr) {
        if (!carList.isEmpty()) {
            return false;
        }

        for(int i = 0; i < nameArr.length; i++) {
            carList.add(new Car(nameArr[i]));
        }

        return true;
    }

    public void setGameCount(int count) {
        this.gameCount = count;
    }

    public int getGameCount() {
        return gameCount;
    }

    public List<Car> getCars() {
        return carList;
    }

    public void play(){
        this.carList.forEach(car -> car.move(RandomHelper.getRandomNumber(DEFAULT_RANDOM_RANGE)));
        playCount++;
    }

    public boolean isEnd(){
        return playCount >= gameCount;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public List<Car> getWinner(){
        Optional<Car> largest = carList.stream()
                .max(Comparator.comparing(Car::getPosition));

        return carList.stream()
                .filter(car -> car.getPosition() == largest.get().getPosition())
                .collect(Collectors.toList());

    }
}
