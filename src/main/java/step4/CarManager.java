package step4;

public class CarManager {
    private Car car;
    private RaceManager raceManager = new RaceManager();

    public CarManager(Car car) {
        this.car = car;
    }

    public void canIGo() {
        if (raceManager.judge()) {
            car.moveForward();
        }
    }

    public int getCurrCarPosition() {
        return car.getPosition();
    }

    public String getCurrCarName() {
        return car.getName();
    }
}
