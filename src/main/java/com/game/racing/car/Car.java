package com.game.racing.car;

/**
 * 자동차 경주 게임 내 개별 자동차
 */
public class Car {
    /**
     * 자동차의 현재 위치 (최초 = 1)
     */
    private Integer position;

    public Integer getPosition() {
        return position;
    }

    public Car() {
        this.position = 1;
    }

    /**
     * 자동차가 움직이게 하는 메소드
     *
     * @return 움직인 이후의 위치를 Integer 형태로 리턴한다
     */
    public Integer move() {
        return ++position;
    }
}
