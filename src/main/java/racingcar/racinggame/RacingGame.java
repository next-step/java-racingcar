package racingcar.racinggame;

import racingcar.car.Car;
import racingcar.common.RandomHelper;
import java.util.ArrayList;

public class RacingGame {
    public final static int DEFAULT_RANDOM_RANGE = 10;
    private ArrayList<Car> carList;
    private int gameCount;
    private int playCount;

    public RacingGame() {
        this.carList = new ArrayList<>();
        playCount = 0;
        gameCount = 0;
    }

    public boolean makeCar(int carCount) {
        if (!carList.isEmpty()) {
            return false;
        }

        for(int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }

        return true;
    }

    public void setGameCount(int count) {
        this.gameCount = count;
    }

    public int getGameCount() {
        return gameCount;
    }

    public ArrayList<Car> getCars() {
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
}
