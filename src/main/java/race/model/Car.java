package race.model;

public class Car {
    public int position;

    public void move(boolean isMovable) {
        if (isMovable) position ++;
    }
}
