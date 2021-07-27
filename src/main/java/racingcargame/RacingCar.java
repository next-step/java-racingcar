package racingcargame;

public class RacingCar {
    private String movingLine = "";

    public String doRandomCalculation(int randomValue) {
        if(randomValue >= 4) {
            return this.move();
        }
        return this.stop();
    }

    private String move() {
        movingLine += "-";
        return movingLine;
    }

    private String stop() {
        movingLine += "";
        return movingLine;
    }
}
