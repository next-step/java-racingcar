package racinggame;

public class Car {

    private int position = 1;

    public int position() {
        return this.position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }
}
