package racing;

public class Game {

    private Car[] cars;

    public Car[] getCars() {
        return cars;
    }

    public void setCarCount(int count) {
        cars = new Car[count];
    }
}
