package step4;

public class Car {

    private int distance;
    private String name;

    Car(String name){
        this.distance = 0;
        this.name = name;
    }

    void move(MoveStrategy moveStrategy){
        this.distance += moveStrategy.getDistance();
    }

    int getDistance(){
        return this.distance;
    }
    String getName(){
        return this.name;
    }

}
