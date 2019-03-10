package racingcar;

public class Car {
    private static final int LOWER_LIMIT_OF_MOVE = 4;
    private int position = 0;

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
}
