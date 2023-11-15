package study.racingCar;

import java.util.PrimitiveIterator;
import java.util.Random;

public class Car {

    private Position position;

    public Car() {
        this(0);
    }

    public Car(int num){
        this.position =  new Position(num);
    }

    public Position currentPosition(){
        return position;
    }

}
