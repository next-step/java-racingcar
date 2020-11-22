package racingcar.domain;

public class Car {

    private  String car;
    private int location;

    public Car(String car){
        this.car = car;
        this.location = 1;
    }

    public String getCar(){
        return car;
    }

    public int getLocation(){
        return location;
    }

    public void moveLocation(){
        this.location = location + 1;
    }
    
}
