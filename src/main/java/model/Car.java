package model;


public class Car {

    private static final String POSITION_STRING_UNIT = "-";
    private final String name;
    private int currentPosition = 0;


    private Car(String name) {
        this.name = name;
    }

    public static Car carWithName(String name) {
        return new Car(name);
    }

    public void move() {
        this.currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(int position){
        return this.currentPosition == position;
    }
    private String positionToString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.currentPosition; i++) {
            builder.append(POSITION_STRING_UNIT);
        }
        return builder + "\n";
    }
    @Override
    public String toString() {
        return this.name + ":" + this.positionToString();
    }

}
