package racingcar;

public class Car {

    private int numberOfMove = 0;

    public Car() {

    }

    public void move(final int random) {
        if (random >= 4) {
            numberOfMove++;
        }
    }

    public String getProgressBar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfMove; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
