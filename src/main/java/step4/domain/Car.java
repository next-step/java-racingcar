package step4.domain;

import step4.util.RandomUtil;

public class Car {
    private final int condition = 4 ;
    Name name;
    Position position;

    public Car(String name) {
        this(new Name(name), new Position());
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        if(condition < RandomUtil.getRandomValue()){
            position.plus();
        }
    }

    public boolean isMoving() {
        return myPosition() > 0;
    }

    public int myPosition() {
        return position.getPosition();
    }

    public String myName() {
        return name.getName();
    }
}
