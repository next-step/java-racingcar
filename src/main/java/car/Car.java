package car;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    public int currentPosition() {
        return this.position;
    }

}
