package racingcar;

public class Car {
    private static final int THRESHOLD_TO_MOVE = 4;

    private String id;
    private int position;

    public Car(String id) {
        this.id = id;
        this.position = 0;
    }

    public Car(String id, int position) {
        this.id = id;
        this.position = position;
    }

    public void move(int randomValue) {
        if (randomValue > THRESHOLD_TO_MOVE) {
            this.position++;
        }
    }

    public String getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }
}