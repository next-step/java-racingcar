package racing;

public class Car {
    private int moveCount = 1;

    public Car() {

    }

    public void moveCar(){
        ++moveCount;
    }

    public int getMoveCount(){
        return moveCount;
    }
}
