package racingcar;

public class RacingCar {

    private String owner;
    private Position position;


    public RacingCar(String owner, Position position) {
        this.owner = owner;
        this.position = position;
    }

    public void move() {
        position.setLocation(isGo(RandomNumber.random()));
    }

    public String status() {
        return position.getLocation();
    }

    public String isGo(int number) {
        if (number >= RandomNumber.MINIMUM_NUMBER) {
            return "-";
        }
        return "";
    }

    public String getOwner() {
        return owner;
    }
}
