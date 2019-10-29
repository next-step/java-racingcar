package com.seok.racing.domain;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Car {

    private final String name;
    private int location;
    private Record record = new Record();
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
        record.record(location);
    }

    public String getName() {
        return name;
    }

    public Record getRecord() {
        return record;
    }

    protected int getLocation() {
        return location;
    }

}
