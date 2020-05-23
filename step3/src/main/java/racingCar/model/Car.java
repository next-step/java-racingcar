package main.java.racingCar.model;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int RANDOM_CUT = 4;
    private static final int RANDOM_BOUND = 10;
    private int position;

    public Car(){
        position=DEFAULT_POSITION;
    }
    public int getPosition() {
        return position;
    }
    void move(){
        int dice =(int)(Math.random()*RANDOM_BOUND);
        position+= dice>=RANDOM_CUT?1:0;
    }
}
