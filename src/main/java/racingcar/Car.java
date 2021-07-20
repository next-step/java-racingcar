package racingcar;

public class Car {

    private int numberOfMove = 0;

    public Car() {

    }

    public void move(final int random) {
        if (isRange(random)) {
            numberOfMove++;
        }
    }

    private boolean isRange(int random) {
        return random >= 4 && random < 10;
    }

    public String getProgressBar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfMove; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
