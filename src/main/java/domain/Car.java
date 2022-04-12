package domain;

public class Car {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final int BOUNDARY_NUMBER = 4;
    private static final String POSITION_BAR = "-";
    private int position;

    public void move(int number) {
        if (number >= BOUNDARY_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public void printPosition() {
        System.out.println(stringBuilder.append(POSITION_BAR.repeat(Math.max(0, position))));
        stringBuilder.setLength(0);
    }
}
