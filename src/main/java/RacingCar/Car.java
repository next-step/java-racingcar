package RacingCar;

import static RacingCar.RacingCar.random;

public class Car {
    int name;
    int position;

    public Car(int name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        this.position += RacingCar.move();
    }

    public int currentPosition(){
        return position;
    }
}
