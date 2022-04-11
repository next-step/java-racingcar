package racing;

public class Car {

    private int position;

    public Car(int position) {
        this.position = position;
    }

    public Car(){
        this(0);
    }

    public int currentPosition() {
        return this.position;
    }

    public void moveForward() {
        this.position ++;
    }
}
