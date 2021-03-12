package carRacing.domain;

import java.util.Random;

public class Car {
    private int score;

    public Car(){
        this.score = 0;
    }

    public Car(Car car){
        this.score = car.score;
    }

    public Car raceOrStay(Car car){
        Car carAfterAction = new Car(car);
        Random random = new Random();
        if(random.nextInt(10)>=4) {
            carAfterAction.score+=1;
        }
        return carAfterAction;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        String trace = "\uD83D\uDE98";
        for (int count = 0; count < this.score; count++) {
            trace += "-";
        }
        return trace;
    }
}
