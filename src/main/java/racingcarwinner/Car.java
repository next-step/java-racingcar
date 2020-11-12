package racingcarwinner;

public class Car {


    private int travelDistance;
    private String name;

    private Car(){ }

    public Car(String name){
        this.name = name;
    }

    public void move(){
        this.travelDistance++;
    }

    public int getTravelDistance(){
        return this.travelDistance;
    }

    public String getName(){
        return this.name;
    }
}
