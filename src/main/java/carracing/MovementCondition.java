package carracing;

public class MovementCondition {

    private int condition;

    public MovementCondition(int condition) {
        this.condition = condition;
    }

    public Boolean isMovable() {
        return condition >= 4;
    }
}
