package racingcar;

public class Car {
    private String position;

    public Car() {
        this.position = "";
    }

    public String getPosition() {
        return position;
    }

    public void move() {
        StringBuilder stringBuilder = new StringBuilder(position);
        this.position = stringBuilder.append("-").toString();
    }

}
