package racingcar;

public class Car {

    private int car;
    private int location;

    public Car(int car){
        this.car = car;
        this.location = 1;
    }

    public int getCar(){
        return car;
    }

    public int getLocation(){
        return location;
    }

    public void moveLocation(){
        this.location = location + 1;
    }
    
}