/*
 * RacingGame execute class
 * 2020.05.14
 * version 1.0.0
 * 저작권 관련
 */

package edu.next.racing.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 레이싱게임 클래스
 *
 * @version 1.0.0
 * @author GwangJunChoi
 */
public class RacingGame {

    /** repetition count */
    private int time = 0;
    /** car object list */
    private List<Car> cars = new ArrayList<>();

    public RacingGame(int carCounts, int time) {
        this.setCars(carCounts);
        this.time = time;
    }
    /**
     * 자동차 객체 리스트 생성
     * @param carCounts 사용자 입력한 숫자
     */
    private void setCars(int carCounts) {
        for (int i = 0; i < carCounts; i++) {
            cars.add(new RacingCar());
        }
    }

    public int getTime() {
        return this.time;
    }

    public void move() {
        cars.forEach(car -> {
            car.move();
        });
    }

    public List<Car> execute() {
        for (int i = 0; i < this.time; i++) {
            move();
        }
        return cars;
    }

}
