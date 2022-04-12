package racing.module;

public class Car {
    private int position = 0;


    public Car(int position) {
        this.position = position;
    }

    public void move(int speed) {
        if (speed >= 4) {
            position += speed;
        }
    }

    public int getPosition() {
        return position;
    }
}
