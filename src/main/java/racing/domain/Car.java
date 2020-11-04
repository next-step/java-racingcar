package racing.domain;

public class Car {

    private int displacement = 0;

    public void move() {
        displacement++;
    }

    public int getDisplacement() {
        return displacement;
    }
}
