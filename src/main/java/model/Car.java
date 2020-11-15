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
    private Name name;

    public Car (String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car (String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
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
        name.print();
        System.out.print(" : ");
        position.print();
        System.out.println();
    }

    public Position getMaxPosition (Position maxPosition) {
        return position.biggerPosition(maxPosition);
    }

    public boolean isWinner (Position maxPosition) {
        return position.equals(maxPosition);
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode () {
        return Objects.hash(position, name);
    }

    public void printName () {
        name.print();
    }
}
