package model;


public class Car {

    private static final String POSITION_STRING_UNIT = "-";
    private final String name;
    private int currentPosition = 0;


    public static Car carWithName(String name){
        return new Car(name);
    }

    private Car(String name){
        this.name = name;
    }
    public void move() {
        this.currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public String toString() {
        return  this.name + ":" + this.positionToString();
    }

    private String positionToString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.currentPosition; i++) {
            builder.append(POSITION_STRING_UNIT);
        }
        return builder + "\n";
    }
}
