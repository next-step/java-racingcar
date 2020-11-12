package racingcar.domain;

public class Car {
    private String name;
    private int numberOfMoves;

    public Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfMoves(){
        return numberOfMoves;
    }

    public void move(MoveStrategy moveStrategy){
        this.numberOfMoves += moveStrategy.getMovingDistance();
    }
}
