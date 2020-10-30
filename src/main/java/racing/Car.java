package racing;

public class Car {

    private int displacement;

    public Car() {
        this.displacement = 0;
    }

    public void move() {
        this.displacement++;
    }

    public int getDisplacement() {
        return displacement;
    }
}
