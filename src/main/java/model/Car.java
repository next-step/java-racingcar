package model;


public class Car {

    private static final String POSITION_UNIT = "-";
    private int currentPosition = 0;

    public void move() {
        this.currentPosition++;
    }

    public String getCurrentPosition() {
        StringBuilder builder = new StringBuilder(POSITION_UNIT);
        for (int i = 0; i < currentPosition; i++) {
            builder.append(POSITION_UNIT);
        }
        return builder + "\n";
    }
}