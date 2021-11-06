package racinggame;

public class Car {
    private StringBuilder moveStatus;

    public Car() {
        this.moveStatus = new StringBuilder();
    }

    public void advance(int moveValue) {
        if(MoveValueValidator.validate(moveValue)) {
            moveStatus.append("-");
        }
    }

    public String advanceStatus() {
        return moveStatus.toString();
    }
}
