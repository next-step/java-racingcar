package study.race;

public class Car {

    private StringBuilder moveHistory;

    public Car() {
        moveHistory = new StringBuilder();
    }

    public void move(int randomNum) {
        if (isMoveCondition(randomNum)) {
            moveHistory.append("-");
        }
    }

    public boolean isMoveCondition(int randomNum) {
        return randomNum >= 4;
    }

    public String showHistory() {
        return moveHistory.toString();
    }

}
