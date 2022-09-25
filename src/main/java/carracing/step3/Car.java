package carracing.step3;

public class Car {
    private int moveCnt;

    public void move() {
        moveCnt += 1;
    }

    public String moveTrace() {
        return "-".repeat(Math.max(0, moveCnt));
    }

}
