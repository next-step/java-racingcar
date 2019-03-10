package racingcar;

public class Car {
    private static final int THRESHOLD_TO_MOVE = 4;

    private int id;
    private int position;

    public Car(int id) {
        this.id = id;
        this.position = 0;
    }

    public int move(int randomValue) {
        if (randomValue > THRESHOLD_TO_MOVE) {
            this.position++;
        }

        return this.position;
    }

    public String displayTrace() {
        String result = id+": ";

        for (int i = 0; i < this.position; i++) {
            result += "-";
        }

        return result;
    }

    public int getPosition() {
        return position;
    }
}