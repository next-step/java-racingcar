package step2;

public class GameInputModel implements InputModel {
    private int countOfCar;
    private int times;

    public GameInputModel(int countOfCar, int times) {
        this.countOfCar = countOfCar;
        this.times = times;
    }

    public int getCountOfCar() {
        return countOfCar;
    }

    public int getTimes() {
        return times;
    }
}
