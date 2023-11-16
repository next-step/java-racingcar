package racing;

import static racing.Validate.validName;

public class Car {
    private static final int START_MOVE = 1;
    private static final int FORWARD_ONE = 1;

    private int moveCount = START_MOVE;
    private String name;

    public Car(String name) {
        validName(name);
        this.name = name;
    }

    public void moveCar(Strategy strategy){
        if (strategy.isMovable()) {
            moveCount += FORWARD_ONE;
        }
    }

    public int getMoveCount(){
        return moveCount;
    }

    public String getCarName(){ return name; }
}
