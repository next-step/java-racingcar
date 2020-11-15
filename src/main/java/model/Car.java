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

import java.util.Objects;

public class Car {
    private Position position;

    public Car () {
        this.position = new Position();
    }

    public Position getPosition () {
        return position;
    }

    public void stepForward (MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position = position.move();
        }
    }

    public void printCar () {
        position.print();
        System.out.println();
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode () {
        return Objects.hash(position);
    }
}
