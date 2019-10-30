package racingCar;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public boolean move() {

        int random = createRandom();

        if (random >= 4) {
            this.position++;
            return true;
        }
        return false;
    }

    public int createRandom() {
        return (int) (Math.random() * 10);
    }

    public int getPosition() {
        return position;
    }
}
