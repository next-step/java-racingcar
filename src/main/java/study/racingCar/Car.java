package study.racingCar;

import java.util.Random;

public class Car {

    Position position;

    public Car() {
        this(0);
    }

    public Car(int num){
        if (num<0){
            throw new IllegalArgumentException();
        }
        this.position =  new Position(num);
    }

    public int randomNum(){
        Random random = new Random();
        return random.nextInt(10)+1;
    }

    public Position forward(boolean b) {
        if (b){
            return this.position.increse();
        }
        return this.position;
    }
}
