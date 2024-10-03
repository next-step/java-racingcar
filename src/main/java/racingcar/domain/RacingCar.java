package racingcar.domain;

public class RacingCar {

    private String status = "-";

    public String getStatus() {
        return status;
    }

    public void move() {
        this.status += "-";
    }

    public void move(boolean movable) {
        if(movable){
            move();
        }
    }
}
