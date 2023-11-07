package carRacing;


import java.util.InputMismatchException;

import static carRacing.MovingStrategy.*;

public class Car {
    private int distance = 0;
    private String name;
    private MovingStrategy movingStrategy;

    public Car(String name, MovingStrategy movingStrategy) {
        this.name = validateName(name);
        this.movingStrategy = movingStrategy;
    }


    public void move(int number) {
        if (movingStrategy.isRide(number)) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return name;
    }

    private String validateName(String name){
        if(name.length()>5){
            throw new InputMismatchException("자동차 이름은 5글자 이상일 수 없습니다.");
        }
        return name;
    }
}
