package racing;

public class Car {
    private final Integer carKey;
    private Integer position;

    public Car(Integer carKey, Integer position) {
        this.carKey = carKey;
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public void move(Moving moving) {
        this.position += moving.move();
    }
}
