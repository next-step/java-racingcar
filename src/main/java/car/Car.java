package car;

import car.randomNumer.RandomNumber;
import car.randomNumer.impl.RadomNumberByRandom;

public class Car {

    public final static int flagNumberForCarMove = 4;
    private int location;
    private String name;
    private final RandomNumber randomNumber;

    public Car() {
        this(new RadomNumberByRandom(10));
    }

    public Car(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public Car(String name) {
        this();
        setCarName(name);
    }

    public Car(String name, int location) {
        this(name);
        this.location = location;
    }

    private void setCarName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("차량 이름은 공백일 수 없습니다.");
        }
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("차량 이름은 1글자에서 5글자까지 가능합니다.");
        }
        this.name = name;
    }

    public String cardName() {
        return this.name;
    }

    public void move() {
        if (getRandomNumber()>= flagNumberForCarMove) {
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
        return this.location > location ? this.location : location;
    }
}
