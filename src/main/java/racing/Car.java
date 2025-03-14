package racing;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int diceValue) {
        if (diceValue >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
