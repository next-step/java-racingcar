package racing.domain;

public class Car {

    private String carName = "";

    private int moveCount = 0;

    public Car(){
        this("test");
    }

    public Car(String carName){
        this.carName = carName;
    }

    public void moveCar(MoveStrategy moveStrategy){
        if(moveStrategy.movable()){
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
