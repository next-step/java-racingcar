package racing;

public class Car {
    private Long position;

    Car() {
        this.position = 0L;
    }

    public void forward(boolean condition) {
        if (condition) this.position++;
    }

    public Long getPosition() {
        return position;
    }
}
