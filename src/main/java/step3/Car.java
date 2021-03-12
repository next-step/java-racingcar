package step3;

public class Car {
    private int distance;
    private MoveStrategy moveStrategy;

    Car(MoveStrategy moveStrategy){
        this.distance = 0;
        this.moveStrategy = moveStrategy;
    }

    void move(){
        this.distance += this.moveStrategy.getDistance();
    }

    int getDistance(){
        return this.distance;
    }

}
