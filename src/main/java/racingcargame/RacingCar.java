package racingcargame;

public class RacingCar {
    String movingLine = "";

    public String move() {
        movingLine += "-";
        return movingLine;
    }

    public String getMovingLine() {
        return movingLine;
    }
}
