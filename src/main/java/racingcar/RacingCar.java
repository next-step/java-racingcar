package racingcar;

public class RacingCar {

    private String owner;
    private Position position;


    public RacingCar(String owner, Position position) {
        this.owner = owner;
        this.position = position;
    }

    public void move() {
        position.setLocation("-");
    }

    public void stop() {
        position.setLocation("");
    }

    public String status() {
        return position.getLocation();
    }

    public void isGo(int number) {
        if (number >= RandomNumber.MINIMUM_NUMBER) {
            move();
            return;
        }
        stop();
    }

    public String getOwner() {
        return owner;
    }
}
