/*
 * RacingGame execute class
 * 2020.05.14
 * version 1.0.0
 * 저작권 관련
 */

package edu.next.racing.model;

import java.util.ArrayList;
import java.util.Random;

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
    private ArrayList<Car> cars = new ArrayList<>();
    /** random int range */
    private static final int MAX_RANDOM_COUNT = 10;
    /** MOVEABLE NUMBER */
    private static final int MOVEABLE_NUMBER = 4;

    /**
     * 자동차 객체 리스트 생성
     * @param carCounts 사용자 입력한 숫자
     */
    public void setCars(int carCounts) {
        for (int i = 0; i < carCounts; i++) {
            cars.add(new Car());
        }
    }

    /**
     * 반복 횟수 setter
     * @param time 반복 횟수
     * @return void
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * 반복 횟수 getter
     * @return time
     */
    public int getTime() {
        return this.time;
    }

    /**
     * @param
     * @return cars
     */
    public ArrayList move() {
        cars.forEach(car -> { car.setPosition(checkMove()); });
        return cars;
    }

    /**
     * 자동차 전진 또는 멈출
     * @return int 자동차 이동 거리
     */
    private int checkMove() {
        return (MOVEABLE_NUMBER <= new Random().nextInt(MAX_RANDOM_COUNT)) ? 1 : 0;
    }

}
