package racingcar.car;

public class Car {

    private static final int MOVABLE_MINIMUM_NUMBER = 4;
    private static final String SYMBOL = "-";
    private int position;

    public void move(int number) {
        if (number >= MOVABLE_MINIMUM_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getPositionAsSymbol() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(SYMBOL);
        }
        return stringBuilder.toString();
    }

}
