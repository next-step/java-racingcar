package racingCar;

public class Car {

    private final int moveCondition;

    private int position;

    public Car(int moveCondition){
        this.moveCondition = moveCondition;
    }

    public void move(){
        this.position++;
    }

    public int getMoveCondition() {
        return moveCondition;
    }

    public int getPosition() {
        return position;
    }
}
