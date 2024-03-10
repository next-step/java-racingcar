package racingcar;

public class Car {
    private static final int ADVANCE_CONDITION_NUMBER = 4;

    private int position = 1;

    public void move(int random) {
        if (random >= ADVANCE_CONDITION_NUMBER) {
            position++;
        }
    }

    public String getPositionWithHyphen() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public int getPosition() {
        return position;
    }
}
