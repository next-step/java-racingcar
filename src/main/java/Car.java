import java.util.Random;

public class Car {
    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int randomNumber) {
        if (isMove(randomNumber)) distance++;
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }

}
