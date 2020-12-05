package step3;

public class Car {

    private int position;

    public void move(int random) {
        if (Checkor.check(random)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
