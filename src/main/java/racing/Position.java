package racing;

public class Position {

    private int number;

    public Position(int number) {
        this.number = number;
    }

    public int getPosition() {
        return number;
    }

    public void increase() {
        number++;
    }
}
