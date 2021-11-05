package car;

public class Car {

    private int position;

    public void forward(int add) {
        this.position += add;
    }

    public int getPosition() {
        return this.position;
    }
}
