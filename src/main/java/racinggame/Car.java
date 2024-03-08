package racinggame;

public class Car {
    public boolean run(MoveCondition condition) {
        if(condition.isMovable()) {
            return true;
        }
        return false;
    }

}
