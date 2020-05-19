/*
 * car object class
 * 2020.05.14
 * version 1.0.0
 * 저작권 관련
 */

package edu.next.racing.model;

/**
 * 자동차 객체
 *
 * @version 1.0.0
 * @author GwangJunChoi
 */
public class Car {

    /** 자동차 현재 위치 */
    private int position = 1;

    /**
     * position setter
     * @param position 위치 설정
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return position 위치 리턴
     */
    public int getPosition() {
        return position;
    }

    public void move(int distance) {
        this.position += distance;
    }

}
