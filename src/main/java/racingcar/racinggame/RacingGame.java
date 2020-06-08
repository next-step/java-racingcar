package racingcar.racinggame;

import racingcar.car.Car;
import racingcar.common.RandomHelper;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    public final static int DEFAULT_RANDOM_RANGE = 10;
    private List<Car> carList;
    private int gameCount;
    private int playCount;

    public RacingGame(int gameCount , String[] carNames) {
        this.carList = new ArrayList<>();
        this.playCount = 0;
        this.gameCount = gameCount;

        if(carNames == null || carNames.length ==0){
            throw new UnsupportedOperationException("Parameter is not valid");
        }

        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i]));
        }
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
        Car winner = Collections.max(carList);
        return carList.stream()
                .filter(car -> car.isEqualPosition(winner.getPosition()))
                .collect(Collectors.toList());
    }
}
