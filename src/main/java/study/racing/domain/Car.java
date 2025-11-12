package study.racing.domain;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (RandomMoveRule.isRandomNumber()) {
            this.position++;
        }
    }

}
