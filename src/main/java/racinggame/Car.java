package racinggame;

import java.util.Random;

public class Car {
    private final Random number = new Random();
    private static final int POSSIBLE_NUMBER = 4;
    private static final int MAX_NUMBER = 9;

    private String name;
    private int location;


    public Car(String name, int location){
        this.location = location;
        this.name = name;
    }

    public void carMove(Car car){
        if(isPossibleMove()){
            car.location++;
        }
    }

    public int getLocation(){
        return location;
    }

    public String getName(){
        return name;
    }

    protected boolean isPossibleMove(){
        return number.nextInt(MAX_NUMBER) >= POSSIBLE_NUMBER;
    }

    public boolean equalsPosition(int maxLocation) {
        return getLocation() == maxLocation;
    }

}
