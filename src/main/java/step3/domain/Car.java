package step3.domain;

public class Car {
    private Integer position;

    public Car(Integer position) {
        this.position = position;
    }

    public void move() {
        position += 1;
    }

    public Integer getPosition() {
        return position;
    }
}
