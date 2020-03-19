package racingcar;

public class Car {
    private static final String ONE_MOVE = "-";
    private int position = 0;
    private StringBuilder strPosition = new StringBuilder();

    public boolean canRun(int randomNum) {
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }

    public void move(boolean canRun) {
        if (canRun) {
            position++;
            strPosition.append(ONE_MOVE);
        }
    }

    public int getPosition() {
        return position;
    }

    public StringBuilder getStrPosition() {
        return strPosition;
    }
}