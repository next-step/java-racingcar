package ch3;

public class Car {

    private int position = 0;
    private String name;

    public int getPosition() {
        return position;
    }

    public String name() {
        return name;
    }

    public void move(int number) {
        final int MOVE_CONDITION_NUMBER = 4;
        if (number >= MOVE_CONDITION_NUMBER) {
            this.position++;
        }
    }

    public void makeName(String name) {
        this.name = name;
    }
}
