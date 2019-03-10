package racingcar;

public class Car {
    private static final int LOWER_LIMIT_OF_MOVE = 4;
    private int position = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(int num) {
        if (num >= LOWER_LIMIT_OF_MOVE)
            this.position++;
    }

    public String getRacingPath() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
