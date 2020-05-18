/*
 * RacingGame execute class
 * 2020.05.14
 * version 1.0.0
 * 저작권 관련
 */

package edu.next.racing.model;

import edu.next.racing.ui.InputView;

import java.util.ArrayList;
import java.util.List;
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
    private List<Car> cars = new ArrayList<>();
    /** random int range */
    private static final int MAX_RANDOM_COUNT = 10;
    /** MOVEABLE NUMBER */
    private static final int MOVEABLE_NUMBER = 4;
    private Random rand = new Random();

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
     * @return cars
     */
    public void move() {
        cars.forEach(car -> {
            car.move((isMoveable()) ? 1 : 0);
        });
    }

    /**
     * 자동차 전진 또는 멈출
     * @return boolean 자동차 움직임 부여
     */
    private boolean isMoveable() {
        return (MOVEABLE_NUMBER <= rand.nextInt(MAX_RANDOM_COUNT));
    }

    public String[] execute() {

        String[] resultString = new String[this.time];

        for (int i = 0; i < this.time; i++) {
            move();
            resultString[i] = carPositionIterator();
        }

        return resultString;

    }


    /**
     * 자동차 객체 리스트 iterator
     * @return distanceLine
     */
    private String carPositionIterator() {

        String distanceLine = "";

        for (Car car : this.cars) {
            distanceLine += this.displayCarLine(car.getPosition()) + "\n";
        }

        return distanceLine;

    }

    /**
     * 자동차 움직인 라인 출력
     * @param position
     * @return line
     */
    private String displayCarLine(int position) {

        String line = "";

        for (int i = 0; i < position; i++) {
            line += "-";
        }

        return line;
    }


}
