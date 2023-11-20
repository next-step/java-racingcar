package racing.domain;

import racing.generator.NumberGenerator;

public class Car {
    private static final int BASIS_RANDOM_VALUE = 4;
    private Position position;
    private Name name;

    public Car(){
        this.position = new Position(0);
    }

    public Car(String name){
        this();
        this.name = new Name(name);
    }

    public void move(){
        this.position.addPosition();
    }

    public void turn(NumberGenerator numberGenerator){
        final int number = numberGenerator.generate();
        if(number >= BASIS_RANDOM_VALUE) move();
    }

    public int getPosition(){
        return this.position.getPosition();
    }

    public String getName(){
        return this.name.getName();
    }

    public boolean isWinner(int maxVal){
        return this.position.getPosition() == maxVal;
    }
}
