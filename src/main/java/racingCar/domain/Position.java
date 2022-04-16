package racingCar.domain;

public class Position {

    private String position = "";

    public Position() {
    }

    public String forward() {
        position += "-";
        return position;
    }

    public String getPosition() {
        return position;
    }
}
