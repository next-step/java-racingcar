package com.seok.racing.domain;


public class Car {

    private static final int FORWARD = 1;
    private static final int IN_PLACE = 0;

    private final String name;
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
        record.record(movable.isMovable() ? FORWARD : IN_PLACE);
    }

    public String getName() {
        return name;
    }

    public Record getRecord() {
        return record;
    }

//    protected int getLocation() {
//        return record.getLocation();
//    }

}
