/*
 * 클래스 이름
 * 자동차
 * 버전 정보
 * 1.0
 * 날짜
 * 2020.11.01
 * 저작권 주의
 */

package model;

public class Car {
    final private int REFERENCE_VALUE = 4;

    private Position position;

    public Car () {
        this.position = new Position();
    }

    public Position getPosition () {
        return position;
    }
}
