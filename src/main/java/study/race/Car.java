package study.race;

public class Car {

    private StringBuilder moveHistory;

    public Car() {
        moveHistory = new StringBuilder();
    }

    public void move() {
        moveHistory.append("-");
    }

    public String showHistory() {
        return moveHistory.toString();
    }

}
