package car;

import car.randomNumer.RandomNumber;
import car.randomNumer.impl.RadomNumberByRandom;

public class Car {

    public final static int FLAG_NUMBER_FOR_CAR_MOVE = 4;
    public final static int BASIC_BOUND_NUMBER = 10;
    public final static int NAME_STRING_MIN_RANGE = 1;
    public final static int NAME_STRING_MAX_RANGE = 5;
    private int location;
    private String name;
    private final RandomNumber randomNumber;

    public Car() {
        this(new RadomNumberByRandom(BASIC_BOUND_NUMBER));
    }

    public Car(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public Car(String name) {
        this();
        if (name.isBlank()) {
            throw new IllegalArgumentException("차량 이름은 공백일 수 없습니다.");
        }
        if (name.length() < NAME_STRING_MIN_RANGE || name.length() > NAME_STRING_MAX_RANGE) {
            throw new IllegalArgumentException("차량 이름은 1글자에서 5글자까지 가능합니다.");
        }
        this.name = name;
    }

    public Car(String name, int location) {
        this(name);
        this.location = location;
    }

    public String cardName() {
        return this.name;
    }

    public void move() {
        if (getRandomNumber()>= FLAG_NUMBER_FOR_CAR_MOVE) {
            this.location++;
        }
    }

    public int getLocation(){
        return this.location;
    }

    private int getRandomNumber(){
        return randomNumber.getRandomNumber();
    }


    public int maxLocation(int location) {
        return Math.max(this.location, location);
    }

    public boolean isMatchLocation(int maxLocation) {
        return this.location == maxLocation;
    }
}
