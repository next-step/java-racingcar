package step4;

public class CarManager {
    private Car car;
    private RaceManager raceManager = new RaceManager();

    public CarManager(Car car) {
        this.car = car;
    }

    public void CanIGo() {
        if (raceManager.judge()) {
            car.MoveForward();
        }
    }

    public int getCurrCarPosition() {
        return car.getPosition();
    }
}
