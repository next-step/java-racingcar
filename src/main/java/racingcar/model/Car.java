package racingcar.model;

public class Car {
    private String name;
    private int position;

    private Car(){

    }

    public Car(String name, int position){
        this.name = name;
        this.position = position;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public void move(){
        this.position++;
    }
}
