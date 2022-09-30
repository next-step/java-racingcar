package com.nextstep.javaRacing.racing.car;

public class Car implements Comparable<Car>{

    private final String name;
    private final MoveStrategy moveStrategy;
    private int position;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        validate();
    }

    private void validate() {
        if(name.length()>5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다 : " + name);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition(){
        return this.position;
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }

    @Override
    public String toString(){
        return String.format("car{name=%s, position=%s}",this.name, this.position);
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }
}
