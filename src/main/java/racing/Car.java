package racing;

public class Car {
    private int moveCount = 1;

    public Car() {

    }

    public void moveCar(Strategy strategy){
        if(strategy.isMovable) {
            ++moveCount;
        }
    }

    public int getMoveCount(){
        return moveCount;
    }
}
