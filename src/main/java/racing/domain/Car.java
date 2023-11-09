package racing.domain;

public class Car {

    private String carName = "";

    private int moveCount = 0;

    public Car(){
        this.carName = carName;
    }

    public Car(String carName){
        this.carName = carName;
    }

    public Car(String carName, int moveCount){
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public void moveCar(boolean move){
        if(move){
            this.moveCount++;
        }
    }

    public int getMoveCount(){
        return this.moveCount;
    }

    public String getCarName(){
        return this.carName;
    }

}
