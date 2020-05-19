package racing;

public class Car {
    private static final int MOVE_MIN_NUMBER = 4;
    private int position;
    
    public Car() {
    }
    
    public void drive() {
        if (isMoveTime(Dice.cast())) {
            move();
        }
    }

    void move() {
        this.position++;
    }

    boolean isMoveTime(int castNumber) {
        return castNumber >= MOVE_MIN_NUMBER;
    }

    public int showMyPosition() {
        return position;
    }
}
