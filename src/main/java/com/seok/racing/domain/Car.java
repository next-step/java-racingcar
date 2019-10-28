package com.seok.racing.domain;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Car {

    private final String name;
    private int location;
    private Queue<Integer> record = new LinkedList<>();
    private Movable movable = new RandomMovable();

    protected Car(String name) {
        this.name = name;
    }

    protected void move() {
        if(movable.isMovable())
            location++;
        record.offer(location);
    }

    protected void setMoveAble(Movable movable) {
        this.movable = movable;
    }

    public String getName() {
        return name;
    }

    public Queue<Integer> getRecord() {
        return record;
    }

    protected int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
