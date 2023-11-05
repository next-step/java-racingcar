package race;

public class Car {
    private final static String STEP_STRING = "-";
    private final MoveStrategy moveStrategy;
    private int position = 0;

    public Car(final MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        final int number = moveStrategy.getNumber();
        if (number >= 4) {
            go();
        }
    }

    private void go() {
        position++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(STEP_STRING);
        }

        return stringBuilder.toString();
    }
}
