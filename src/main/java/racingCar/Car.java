package racingCar;


public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move() {
        this.distance += 1;
    }

    public boolean canBeMove(int value) {
        return (value >= 4);
    }

    public void play(int number) {
        if(canBeMove(number)) {
            move();
        }
    }
}
