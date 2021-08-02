package racing.model;


public class Car {

    private static final int INIT_DISTANCE = 0;
    private CarInfo carInfo;
    private Distance distance;

    public Car(String carName) {
        this.carInfo = new CarInfo(carName);
        this.distance = new Distance(INIT_DISTANCE);
    }

    public Car(String carName, int distance) {
        this.carInfo = new CarInfo(carName);
        this.distance = new Distance(distance);
    }

    public int totalDistance() {
        return this.distance.getDistance();
    }

    public boolean run(MovingStrategy move) {
        if(move.movable()) {
            distance.forward();
            return true;
        }
        return false;
    }

    public Boolean validDistance(int distance) {
        return this.distance.getDistance() == distance;
    }

    public String carName() {
        return this.carInfo.name();
    }
}
