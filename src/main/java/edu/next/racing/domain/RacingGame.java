/*
 * RacingGame execute class
 * 2020.05.14
 * version 1.0.0
 * 저작권 관련
 */

package edu.next.racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 레이싱게임 클래스
 *
 * @version 1.0.0
 * @author GwangJunChoi
 */
public class RacingGame {

    /** repetition count */
    private int time = 0;
    private int winnerPosition = 0;
    /** car object list */
    private List<Car> cars = new ArrayList<>();

    public RacingGame(String[] inputCars, int time) {
        for (String name : inputCars) {
            this.setCars(name);
        }
        this.time = time;
    }

    private void setCars(String name) {
        cars.add(new RacingCar(name));
    }

    public int getTime() {
        return this.time;
    }

    public void move() {
        cars.forEach(car -> {
            car.move();
            car.record();
        });
    }

    private void setWinnerPosition() {
        winnerPosition = cars.stream()
                            .mapToInt(car -> car.getPosition())
                            .max()
                            .getAsInt();
    }

    public List<Car> getWinner() {
        setWinnerPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    public List<Car> execute() {
        for (int i = 0; i < this.time; i++) {
            move();
        }
        return cars;
    }

}
