package car;

import car.randomNumer.RandomNumber;
import car.randomNumer.impl.RadomNumberByRandom;

public class Car {

    private int location;
    private final int flagNumberForCarMove = 4;
    private final RandomNumber randomNumber;

    public Car() {
        randomNumber = new RadomNumberByRandom(10);
    }

    public Car(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
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
}
