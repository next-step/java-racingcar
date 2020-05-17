package step3;

public class Car {
    private int position;

    Car() {
        position = 1;
    }

    public int move() {
        this.position = this.position + 1;
        return this.position 
    }

    public int getPosition() {
        return position;
    }
}
