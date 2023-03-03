package racingcar;

public class Car {

    private String name;

    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void addMove(int move) {
        position += move;
    }

    public String toString() {
        return name + " : " + position;
    }
}
