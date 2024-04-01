package racingcar.domain;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private CarName carName;
    private CarLocation location;

    public Car(String name) throws Exception {
        this.carName = new CarName(name);
        this.location = new CarLocation();
    }

    public void move(int condition) {
        if (condition >= MOVE_CONDITION) {
            location.increase();
        }
    }

    public boolean isMax(int max){
        return location.isMaxLocation(max);
    }

    public int checkMaxLocation(int carLocation){
        return location.checkMaxLocation(carLocation);
    }

    public String locationMark() {
        return location.locationMark();
    }

    @Override
    public String toString() {
        return carName.toString();
    }
}
