package racingCar;

public class Car {
    public int distance;

    public void move(int randomNumber) {
        if (randomNumber > 3) {
            distance++;
        }
    }
}
