package step3;

public class Car {
    private Integer position = 0;

    public Car(int position) {
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}
