package racing;

public class Car {
    private int moveCount = 1;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar(Strategy strategy){
        if(strategy.isMovable()) {
            moveCount += 1;
        }
    }

    public int getMoveCount(){
        return moveCount;
    }

    public String getCarName(){ return name; }
}
