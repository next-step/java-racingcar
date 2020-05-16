package racingcar.racinggame;

import racingcar.car.Car;

import java.util.ArrayList;

public class RacingGame {
    public final static int DEFAULT_VALID_MOVING_NUMBER = 4;
    public final static String DEFAULT_CAR_POSITION_SYMBOL = "-";

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
            carList.add(new Car(i+"번 자동차"));
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
        this.carList.forEach(car -> car.move(DEFAULT_VALID_MOVING_NUMBER));
        playCount++;
    }

    public String getCarTraceSymbolByCar(Car car){
        String result ="";
        for (int i = 0; i < car.getPosition(); i++) {
            result = result.concat(DEFAULT_CAR_POSITION_SYMBOL);
        }
        return result;
    }

    public boolean isEnd(){
        return playCount >= gameCount;
    }

    public int getPlayCount() {
        return this.playCount;
    }
}
