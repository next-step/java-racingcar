package com.seok.racing.domain;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Car {

    private final String name;
    private int location;
    private Queue<Integer> record = new LinkedList<>();
    private Movable movable;

    protected Car(String name) {
        this(name, new RandomMovable());
    }

    public Car(String name, Movable movable) {
        this.name = name;
        this.movable = movable;
    }

    protected void move() {
        if (movable.isMovable()) {
            location++;
        }
        record.offer(location);
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

}
