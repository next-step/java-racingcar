package racingcar.domains;

public class RacingCar {

    private String movePath;

    public RacingCar() {
        movePath = "";
    }

    public void moveForward() {
        movePath = movePath + "-";
    }

    public String getMovePath() {
        return movePath;
    }

}
