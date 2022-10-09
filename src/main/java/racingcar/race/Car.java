package racingcar.race;

public class Car {
    private String position;

    public Car() {
        this.position = "";
    }

    public void move() {
        StringBuilder stringBuilder = new StringBuilder(position);
        this.position = stringBuilder.append("-").toString();
    }
    public String getPosition() {
        return position;
    }

}
